import org.junit.*;
import static org.junit.Assert.*;

public class CdTest {

  // UNIT TESTING
  @Test
  public void Cd_InstantiatesCorrectly_Cd(){
    Cd testCd = new Cd("Mozart Part II");
    assertEquals(true, testCd instanceof Cd);
  }

  @Test
  public void Cd_GetsTitle_MozartPartII(){
    Cd testCd = new Cd("Mozart Part II");
    assertEquals("Mozart Part II", testCd.getTitle());
  }


}
