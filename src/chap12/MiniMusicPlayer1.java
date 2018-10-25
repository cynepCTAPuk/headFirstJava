package chap12;

import javax.sound.midi.*;

class MiniMusicPlayer1 {
    public static void main(String[] args) {
        try {
            Sequencer sequencer = MidiSystem.getSequencer(); // create Sequencer
            sequencer.open(); // open Sequencer
            Sequence seq = new Sequence(Sequence.PPQ, 4); //create sequence
            Track track = seq.createTrack(); //create track
            for (int i = 5; i < 61; i++) {
                track.add(makeEvent(144, 1, i, 100, i));
                track.add(makeEvent(128, 1, i, 100, i + 2));
            } // end loop
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } //end main

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
