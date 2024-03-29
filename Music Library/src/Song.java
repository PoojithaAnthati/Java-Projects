import java.util.*;

public class Song {
    private static int counter = 1;
    private int songId;
    private int artistId;
    private String title;
    private String genre;
    private int releaseYear;
    private String language;
    private int totalListens;

    public Song(int artistId, String title, String genre, int releaseYear, String language) {
        this.artistId = artistId;
        this.title = title;
        this.genre =genre;
        this.releaseYear = releaseYear;
        this.language =language;
        this.songId = counter;
        counter++;
        this.totalListens = 0;
    }

    public void markPlayed() {
        this.totalListens++;
    }

    public int getSongId() {
        return this.songId;
    }

    public int getArtistId() {
        return this.artistId;
    }

    public String getTitle() {
        return this.title;
    }
}
