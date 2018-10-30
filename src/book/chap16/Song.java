package book.chap16;

public class Song implements Comparable<Song> {
    private String title, artist, rating, bpm;

    Song(String title, String artist, String rating, String bpm) {
        this.title = title;
        this.artist = artist;
        this.rating = rating;
        this.bpm = bpm;
    }

    private String getTitle() {
        return title;
    }

    String getArtist() {
        return artist;
    }

    String getRating() {
        return rating;
    }

    public String getBpm() {
        return bpm;
    }

    public String toString() {
        return title;
//        return "\""+title+"\"" + " " + artist;
    }

    public int compareTo(Song s) {
        return title.compareTo(s.getTitle());
    }

    public boolean equals(Object aSong) {
        Song s = (Song) aSong;
        return getTitle().equals(s.getTitle());
    }

    public int hashCode() {
        return title.hashCode();
    }
}
