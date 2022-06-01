
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MusicLibrary {
    private Map<Integer, Song> songs = new HashMap<>();
    private Map<Integer, Artist> artists = new HashMap<>();
    private Map<Integer, User> users = new HashMap<>();

    private Map<Integer, Integer> songPlayCounts = new HashMap<>(); //songId, Lsitens
    private Map<Integer, Map<Integer, Integer>> userPlayHistory = new HashMap<>(); //user, songId, Lsitens

    private List<Map.Entry<Integer, Integer>> getTopNByValue(Map<Integer, Integer> map, int n) {
        Set<Map.Entry<Integer, Integer>> s = map.entrySet();
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(s) ;
        
        //Take Top 10 from above list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if(o2.getValue() > o1.getValue()) return 1; //swap - using comparator
                return -1; //no swap - using comparator
            }
        });

        return  list.subList(0, Math.min(n, list.size()));
    }

    public void getTop10Songs() {
        List<Map.Entry<Integer, Integer>> top10Songs = getTopNByValue(songPlayCounts, 10);
        for(int i = 0; i < top10Songs.size(); i++) {
            System.out.println(songs.get(top10Songs.get(i).getKey()).getTitle() +
             " , played: " + top10Songs.get(i).getValue() + " times");
        }
    }

    public void getTop10SongsForUser(int userId) throws Exception {
        if(!users.containsKey(userId)) {
            throw new Exception("User not found");
        }

        Map<Integer, Integer> userSongs = userPlayHistory.get(userId);
        List<Map.Entry<Integer, Integer>> top10Songs = getTopNByValue(userSongs, 10);
        for(int i = 0; i < top10Songs.size(); i++) {
            System.out.println(songs.get(top10Songs.get(i).getKey()).getTitle() +
             " , played: " + top10Songs.get(i).getValue() + " times");
        }
    }

    public void playSong(int userId, int songId) throws Exception {
        if(!users.containsKey(userId)) {
            throw new Exception("User not found");
        }

        if(!songs.containsKey(songId)) {
            throw new Exception("Song not present");
        }

        int songPlayCount = songPlayCounts.containsKey(songId) ? songPlayCounts.get(songId) : 0;
        songPlayCounts.put(songId, songPlayCount + 1);

        Map<Integer, Integer> usersCount = userPlayHistory.get(userId);
        int currUserSongPlayCount = 0;
        if(usersCount == null) {
            usersCount = new HashMap<>();
        }
        else {
            currUserSongPlayCount = usersCount.containsKey(songId) ? usersCount.get(songId) : 0;
        }

        usersCount.put(songId, currUserSongPlayCount + 1);
        userPlayHistory.put(userId, usersCount);
    }

    public User registerUser(String firstName, String lastName, String city, String locality, String state, int pinCode, String email, String phoneNumber) {
        User newUser = new User(firstName, lastName, city, locality, state, pinCode, email, phoneNumber);
        users.put(newUser.getUserId(), newUser);
        return newUser;
    }

    public Artist registerArtist(String firstName, String lastName) {
        Artist newArtist = new Artist(firstName, lastName);
        artists.put(newArtist.getArtistId(), newArtist);
        return newArtist;
    }

    public Song addSong(int artistId, String title, String genre, int releaseYear, String language) throws Exception {
        if(!artists.containsKey(artistId)) {
            throw new Exception("Artist not present");
        }
        Song newSong = new Song(artistId, title, genre, releaseYear, language);
        songs.put(newSong.getSongId(), newSong);
        artists.get(artistId).releaseSong(newSong);
        return newSong;
    }

    public void getSongByArtist(int artistId) throws Exception {
        if(!artists.containsKey(artistId)) {
            throw new Exception("Artist not present");
        }

        for(Song song: songs.values()) {
            if(song.getArtistId() == artistId) {
                System.out.println(song.getTitle());
            }
        }
    }

    public void printArtists() {
        Set<Integer> artistsInfo = artists.keySet();
        for(Integer artistId : artistsInfo) {
            System.out.println("ArtistId: " + artistId +
                               "Artistname: " + "getName()");
        }
    }
}
