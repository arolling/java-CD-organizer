import java.util.ArrayList;

public class Artist {
  private String mName;
  private ArrayList<Cd> mCdsByArtist = new ArrayList<Cd>();
  private static ArrayList<Artist> mAllArtists = new ArrayList<Artist>();

  public Artist(String name) {
    mName = name;
    mAllArtists.add(this);
  }

  public void addTitle(Cd newCd) {
    mCdsByArtist.add(newCd);
  }

  public ArrayList<Cd> getCdsByArtist() {
    return mCdsByArtist;
  }

  public String getName() {
    return mName;
  }

  public static ArrayList<Artist> all() {
    return mAllArtists;
  }

  public static void clear() {
    mAllArtists.clear();
  }

}
