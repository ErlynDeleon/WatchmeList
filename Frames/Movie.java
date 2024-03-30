package Frames;

public class Movie {
  private String title;
  private String genre;
  private int releaseYear;

  public Movie(String title, String genre, int releaseYear) {
      this.title = title;
      this.genre = genre;
      this.releaseYear = releaseYear;
  }

  public String getTitle() {
      return title;
  }

  public void setTitle(String title) {
      this.title = title;
  }

  public String getGenre() {
      return genre;
  }

  public void setGenre(String genre) {
      this.genre = genre;
  }

  public int getReleaseYear() {
      return releaseYear;
  }

  public void setReleaseYear(int releaseYear) {
      this.releaseYear = releaseYear;
  }
}

