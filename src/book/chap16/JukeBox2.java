package book.chap16;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class JukeBox2 {
    ArrayList<String> songList = new ArrayList<String>();

    public static void main(String[] args) {
        new JukeBox2().go();
    }
    void go() {
        getSong();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);
    }
    void getSong() {
        try {
            File file = new File("SongList.txt");
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
        songList.add(tokens[0]);
    }
}
