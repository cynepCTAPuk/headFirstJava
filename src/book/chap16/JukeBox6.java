package book.chap16;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class JukeBox6 {
    ArrayList<Song> songList = new ArrayList<Song>();

    public static void main(String[] args) {
        new JukeBox6().go();
    }

    void go() {
        getSong();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);

        HashSet<Song> songHashSet = new HashSet<Song>();
        songHashSet.addAll(songList);
        System.out.println(songHashSet);
    }

    void getSong() {
        try {
            File file = new File("SongListMore.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                addSong(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void addSong(String lineToParse) {
        String[] tokens = lineToParse.split("/");
        Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
        songList.add(nextSong);
    }
}
