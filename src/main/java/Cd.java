import java.util.ArrayList;

public class Cd {
  private String mTitle;
  private static ArrayList<Cd> mAllCds = new ArrayList<Cd>();

  public Cd(String title) {
    mTitle = title;
    mAllCds.add(this);
  }

  public String getTitle() {
    return mTitle;
  }

  public static ArrayList<Cd> all(){
    return mAllCds;
  }

  public static void clear() {
    mAllCds.clear();
  }
}
