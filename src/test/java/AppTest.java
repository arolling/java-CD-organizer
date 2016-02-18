import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import org.openqa.selenium.JavascriptExecutor;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver(true);
  @Override
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Rule
  public ClearRule clearRule = new ClearRule();

  //Integration testing
  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("CD Organizer");
  }

  @Test
  public void newCDTest() {
    goTo("http://localhost:4567/");
    fill("#cdTitle").with("Mozart Part II");
    fill("#cdArtist").with("Wolfgang Amadeus Mozart");
    submit("#addTitle");
    click("a", withText("Wolfgang Amadeus Mozart"));
    assertThat(pageSource()).contains("Mozart Part II");
    assertThat(pageSource()).contains("Wolfgang");
  }

  @Test
  public void multipleCDTest() {
    goTo("http://localhost:4567/");
    fill("#cdTitle").with("Mozart Part II");
    fill("#cdArtist").with("Wolfgang Amadeus Mozart");
    submit("#addTitle");
    fill("#cdTitle").with("Greatest Hits");
    fill("#cdArtist").with("Amy Grant");
    submit("#addTitle");
    assertThat(pageSource()).contains("Wolfgang Amadeus Mozart");
    assertThat(pageSource()).contains("Amy Grant");
  }

  @Test
  public void multipleCDSameArtistTest() {
    goTo("http://localhost:4567/");
    fill("#cdTitle").with("Mozart Part II");
    fill("#cdArtist").with("Amy Grant");
    submit("#addTitle");
    fill("#cdTitle").with("Greatest Hits");
    fill("#cdArtist").with("Amy Grant");
    submit("#addTitle");
    click("a", withText("Amy Grant"));
    assertThat(pageSource()).contains("Mozart Part II");
    assertThat(pageSource()).contains("Greatest Hits");
    assertThat(pageSource()).contains("Amy Grant");
  }

}
