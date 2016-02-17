import java.util.ArrayList;

public class Artist {
  private String mName;
  //private static ArrayList<Cd> mCdsByArtist = new ArrayList<Cd>();
  private static ArrayList<Artist> mAllArtists = new ArrayList<Artist>();

  public Artist(String name) {
    mName = name;
    mAllArtists.add(this);
    //ArrayList of titles by this artist
  }

  public String getName() {
    return mName;
  }

  public static ArrayList<Artist> all() {
    return mAllArtists;
  }
  
  public static void clear() {
    mAllArtists.clear();
    //mCdsByArtist.clear();
  }

}
