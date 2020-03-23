package unsort;

import java.util.ArrayList;
import java.util.List;

public class RecordTest {
    public static void main(String[] args) {
        var videos = new ArrayList<Video>() {{
            add(new Video(42l, "JDK 14 news"));
            add(new Video(43l, "Spring 6 news"));
        }};
        var playlist = new Playlist(12l, "Java news", videos);
        System.out.println(playlist.length());
    }
}

interface Indexable {
    long id();
}

class Video {
    long id;
    String name;

    public Video(long id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Playlist implements Indexable {
    long id;
    String name;
    List<Video> videos;

    public Playlist(long id, String name, List<Video> videos) {
        this.id = id;
        this.name = name;
        this.videos = videos;
    }

    @Override
    public long id() {
        return id;
    }

    public int length() {
        return videos.size();
    }
}