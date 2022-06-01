import java.util.*;

public class Artist {
    private static int counter = 1;
    private int artistId;
    private String firstName;
    private String lastName;
    private ArrayList<Song> releasedSongs;
    private Date registrationTimeStamp;

    public Artist(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registrationTimeStamp = new Date();
        this.releasedSongs = new ArrayList<Song>();
        this.artistId = counter;
        counter++;
    }

    public int getArtistId() {
        return this.artistId;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public Date getRegistrationTimeStamp() {
        return this.registrationTimeStamp;
    }

    public void releaseSong(Song song) {
        this.releasedSongs.add(song);
    }
}