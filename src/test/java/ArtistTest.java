import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class ArtistTest {
  @Rule
  public ClearRule clearRule = new ClearRule();

  // UNIT TESTING
  @Test
  public void Artist_instantiatesArtistCorrectly_Artist(){
    Artist testArtist = new Artist("Amy Grant");
    assertEquals(true, testArtist instanceof Artist);
  }

  @Test
  public void Artist_getArtistCorrectly_Artist(){
    Artist testArtist = new Artist("Amy Grant");
    assertEquals("Amy Grant", testArtist.getName());
  }

  @Test
  public void Artist_addsArtistCorrectlyToList_3ArtistsInList(){
    Artist testArtist = new Artist("Amy Grant");
    Artist testArtist2 = new Artist("Bob Marley");
    Artist testArtist3 = new Artist("Ted Nugent");
    assertEquals(3, Artist.all().size());
  }

  @Test
  public void Artist_addTitleObjectCorrectly_addTitle(){
    Cd testCd = new Cd("Mozart Part II");
    Cd testCd2 = new Cd("Mozart Greatest Hits");
    Artist testArtist = new Artist("Amy Grant");
    testArtist.addTitle(testCd);
    testArtist.addTitle(testCd2);
    ArrayList<Cd> testArrayCompare = new ArrayList<Cd>();
    testArrayCompare.add(testCd);
    testArrayCompare.add(testCd2);
    assertEquals(testArrayCompare, testArtist.getCdsByArtist());
  }
}
