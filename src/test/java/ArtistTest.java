import org.junit.*;
import static org.junit.Assert.*;

public class ArtistTest {

  // UNIT TESTING
  @Test
  public void Artist_instantiatesArtistCorrectly_Artist(){
    Artist testArtist = new Artist("Amy Grant");
    assertEquals(true, testArtist instanceof Artist);
  }


}
