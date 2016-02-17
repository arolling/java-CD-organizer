import org.junit.*;
import static org.junit.Assert.*;

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

  // @Test
  // public void Artist_addTitleObjectCorrectly_addTitle(){
  //   Cd testCd = new Cd("Mozart Part II");
  //   Artist testArtist = new Artist("Amy Grant");
  //
  //   assertEquals("Mozart Part II", testArtist.addTitle());
  // }
}
