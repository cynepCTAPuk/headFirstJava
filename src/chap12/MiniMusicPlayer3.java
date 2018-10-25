package chap12;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

public class MiniMusicPlayer3 {

    static JFrame f = new JFrame("My First Music Video");
    static MyDrawPanel ml;

    public static void main(String[] args) {
        MiniMusicPlayer3 mini = new MiniMusicPlayer3();
        mini.go();
    } // end main

    public void setUpGui() {
        ml = new MyDrawPanel();
        f.setContentPane(ml);
        f.setBounds(500, 300, 500, 500); // original (30, 30, 300, 300)
        f.setVisible(true);
    } // end setUpGui() method

    public void go() {
        setUpGui();

        try {
            Sequencer sequencer = MidiSystem.getSequencer(); // create Sequencer
            sequencer.open(); // open Sequencer
            sequencer.addControllerEventListener(ml, new int[]{127});
            Sequence seq = new Sequence(Sequence.PPQ, 4); //create sequence
            Track track = seq.createTrack(); //create track

            int r = 0;
            for (int i = 0; i < 120; i ++) { // original int i=0;i<60;i+=4
                r = (int) ((Math.random() * 50) + 1);
                track.add(makeEvent(144, 1, r, 100, i));
                track.add(makeEvent(176, 1, 127, 0, i));
                track.add(makeEvent(128, 1, r, 100, i + 2));
            } // end loop

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(120); // original 120
            sequencer.start();
        } catch (Exception ex) {ex.printStackTrace();}
    } //end go() method

    public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {}
        return event;
    } // end MidiEvent() method


    class MyDrawPanel extends JPanel implements ControllerEventListener {
        boolean msg = false;

        public void controlChange(ShortMessage event) {
            msg = true;
            repaint();
        } //end controlChange() method

        public void paintComponent(Graphics g) {
            if (msg) {

                Graphics2D g2 = (Graphics2D) g;

                int red = (int) (Math.random() * 250);
                int green = (int) (Math.random() * 250);
                int blue = (int) (Math.random() * 250);

                g.setColor(new Color(red, green, blue));

                int width = (int) ((Math.random() * 200) + 10); // *120
                int height = (int) ((Math.random() * 200) + 10); // *120

                int x = (int) ((Math.random() * 200) + 10); // *40
                int y = (int) ((Math.random() * 200) + 10); // *30

                g.fillRect(x, y, width, height);
                msg = false;
            } // end if
        } // end paintComponent(Graphics g) method
    } //end MyDrawPanel class (inner)
} // end MiniMusicPlayer1 class (outer)