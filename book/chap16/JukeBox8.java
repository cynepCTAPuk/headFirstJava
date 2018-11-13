package chap16;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class JukeBox8 {
    ArrayList<Song> songList = new ArrayList<Song>();

    public static void main(String[] args) {
        new JukeBox8().go();
    }

    void go() {
        getSong();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);

        TreeSet<Song> songTreeSet = new TreeSet<Song>();
        songTreeSet.addAll(songList);
        System.out.println(songTreeSet);
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
