import org.junit.*;
import static org.junit.Assert.*;

public class CdTest {
  @Rule
  public ClearRule clearRule = new ClearRule();

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

  @Test
  public void Cd_addsToAllCdsArray_ThreeObjectsInArrayList(){
    Cd testCd = new Cd("Mozart Part II");
    Cd testCd2 = new Cd("Mozart Greatest Hits");
    Cd testCd3 = new Cd("Amy Grant Feelings");
    assertEquals(3, Cd.all().size());
  }


}
