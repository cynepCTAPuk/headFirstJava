package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

/*
        TestBean testBean = context.getBean("testBean", TestBean.class);
        System.out.println(testBean.getName());
*/
/*
        Music music = context.getBean("musicBean", Music.class);
        MusicPlayer musicPlayer = new MusicPlayer(music);
*/
/*
        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.playMusic();
        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());

        MusicPlayer musicPlayer2 = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.setVolume(111);
        System.out.println(musicPlayer.getVolume());
        System.out.println(musicPlayer2.getVolume());
        System.out.println(musicPlayer.equals(musicPlayer2));
        System.out.println(musicPlayer == musicPlayer2);
*/
        ClassicMusic classicMusic = context.getBean("musicBean", ClassicMusic.class);
        System.out.println(classicMusic.getSong());
        System.out.println(classicMusic);
        ClassicMusic classicMusic1 = context.getBean("musicBean", ClassicMusic.class);
        System.out.println(classicMusic1.getSong());
        System.out.println(classicMusic1);


        context.close();
    }
}
