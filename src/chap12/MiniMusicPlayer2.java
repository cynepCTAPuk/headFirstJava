package chap12;

import javax.sound.midi.*;

class MiniMusicPlayer2 implements ControllerEventListener {

    public static void main(String[] args) {
        MiniMusicPlayer2 mini = new MiniMusicPlayer2();
        mini.go();
    } // end main

    public void go() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer(); // create Sequencer
            sequencer.open(); // open Sequencer

            int[] eventsWant = {127};
            sequencer.addControllerEventListener(this, eventsWant);

            Sequence seq = new Sequence(Sequence.PPQ, 4); //create sequence
            Track track = seq.createTrack(); //create track

            for (int i = 5; i < 80; i++) { // original i<60
                track.add(makeEvent(144, 1, i, 100, i));
                track.add(makeEvent(176, 1, 127, 0, i));
                track.add(makeEvent(128, 1, i, 100, i + 2));
            } // end loop

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(100); // original 220
            sequencer.start();
//            sequencer.stop();
//            sequencer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } //end go method

    public void controlChange(ShortMessage event) {
        System.out.print("la ");
    }

    public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {
        }
        return event;
    } // end MidiEvent method
} // end MiniMusicPlayer1 class
