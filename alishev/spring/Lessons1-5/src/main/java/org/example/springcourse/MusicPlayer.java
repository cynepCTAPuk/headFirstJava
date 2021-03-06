package org.example.springcourse;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
//    private Music music;
    private List<Music> musicList = new ArrayList<>();
    private String name;
    private int volume;

/*
    public MusicPlayer(Music music) {
        this.music = music;
    }

    public MusicPlayer() {
    }

    public void setMusic(Music music) {
        this.music = music;
    }
*/

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void playMusic() {
//        System.out.println("Playing: " + music.getSong());
        for(Music music: musicList) System.out.println("Playing: " + music.getSong());
    }
}
