package chap13;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class BeatBox {

    JPanel mainPanel;
    ArrayList<JCheckBox> checkboxList;
    Sequencer sequencer;
    Sequence sequence;
    Track track;
    JFrame frame;

    String[] instrumentNames = {"Bass Drum -барабан", "Closed Hi-Hat",
            "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap -хлопок",
            "High Tom", "Hi Bongo", "Maracas", "Whistle -свисток", "Low Conga",
            "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo",
            "Open Hi Conga"};
    int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) screenSize.getWidth();
    int height = (int) screenSize.getHeight();
    int widthFrame = 500;
    int heightFrame = 500;

    public static void main(String[] args) {
        new BeatBox().buildGUI();
    } // end main

    public void buildGUI() {
        frame = new JFrame("Cyber BeatBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        checkboxList = new ArrayList<JCheckBox>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        start.addActionListener(new MyStartListener());
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener(new MyStopListener());
        buttonBox.add(stop);

        JButton upTempo = new JButton("Tempo Up");
        upTempo.addActionListener(new MyUpTempoListener());
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("Tempo Down");
        downTempo.addActionListener(new MyDownTempoListener());
        buttonBox.add(downTempo);

        JButton saveTrack = new JButton("Save");
        saveTrack.addActionListener(new SaveTrackListener());
        buttonBox.add(saveTrack);

        JButton loadTrack = new JButton("Load");
        loadTrack.addActionListener(new LoadTrackListener());
        buttonBox.add(loadTrack);

        JButton quickSave = new JButton("Quick Save");
        quickSave.addActionListener(new QuickSaveListener());
        buttonBox.add(quickSave);

        JButton quickLoad = new JButton("Quick Load");
        quickLoad.addActionListener(new QuickLoadListener());
        buttonBox.add(quickLoad);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < 16; i++) {
            nameBox.add(new Label(instrumentNames[i]));
        }

        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);

        frame.getContentPane().add(background);

        GridLayout grid = new GridLayout(16, 16);
        grid.setVgap(1);
        grid.setHgap(2);
        mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER, mainPanel);

        for (int i = 0; i < 256; i++) {
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkboxList.add(c);
            mainPanel.add(c);
        } // end loop

        setUpMidi();

        frame.setBounds(width / 2 - widthFrame / 2, height / 2 - heightFrame / 2, widthFrame, heightFrame);
        frame.pack();
        frame.setVisible(true);
    } // end buildGUI method

    public void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);

        } catch (Exception e) {
            e.printStackTrace();
        }
    } // end setUpMidi method

    public void buildTrackAndStart() {
        int[] trackList = null;

        sequence.deleteTrack(track);
        track = sequence.createTrack();

        for (int i = 0; i < 16; i++) {
            trackList = new int[16];

            int key = instruments[i];

            for (int j = 0; j < 16; j++) {
                JCheckBox jc = (JCheckBox) checkboxList.get(j + (16 * i));
                if (jc.isSelected()) {
                    trackList[j] = key;
                } else {
                    trackList[j] = 0;
                } // end if
            } // end inner loop
            makeTracks(trackList);
            track.add(makeEvent(176, 1, 127, 0, 16));
        } // end outer loop

        track.add(makeEvent(192, 9, 1, 0, 15));
        try {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            sequencer.setTempoInBPM(120);
            sequencer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // end buildTrackAndStart method

    public class MyStartListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            buildTrackAndStart();
        }
    } // end MyStartListener inner class

    public class MyStopListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            sequencer.stop();
        }
    } // end MyStopListener inner class

    public class MyUpTempoListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float) (tempoFactor * 1.03));
        }
    } // end MyUpTempoListener inner class

    public class MyDownTempoListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float) (tempoFactor * .97));
        }
    } // end MyDownTempoListener inner class

    public class SaveTrackListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            JFileChooser fileSave = new JFileChooser();
            fileSave.showSaveDialog(frame);
            saveFile(fileSave.getSelectedFile());
        } // end actionPerformed method
    } // end SaveTrackListener inner class

    public class LoadTrackListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            JFileChooser fileLoad = new JFileChooser();
            fileLoad.showSaveDialog(frame);
            loadFile(fileLoad.getSelectedFile());
        } // end actionPerformed method
    } // end SaveTrackListener inner class

    public class QuickSaveListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            boolean[] checkboxState = new boolean[256];
            for (int i = 0; i < 256; i++) {
                JCheckBox check = (JCheckBox) checkboxList.get(i);
                if (check.isSelected()) checkboxState[i] = true;
            } // end loop
            System.out.println(Arrays.toString(checkboxState));
            try {
                FileOutputStream fileStream = new FileOutputStream(new File("checkbox.ser"));
                ObjectOutputStream os = new ObjectOutputStream(fileStream);
                os.writeObject(checkboxState);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } // end actionPerformed method
    } // end MySendListener class

    public class QuickLoadListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            boolean[] checkboxState = null;
            try {
                FileInputStream fileStream = new FileInputStream(new File("checkbox.ser"));
                ObjectInputStream is = new ObjectInputStream(fileStream);
                checkboxState = (boolean[]) is.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 256; i++) {
                JCheckBox check = (JCheckBox) checkboxList.get(i);
                if (checkboxState[i]) check.setSelected(true);
                else check.setSelected(false);
            } // end loop
            System.out.println(Arrays.toString(checkboxState));
            sequencer.stop();
            buildTrackAndStart();
        } // end actionPerformed method
    } // end MySendListener class

    public void makeTracks(int[] list) {
        for (int i = 0; i < 16; i++) {
            int key = list[i];

            if (key != 0) {
                track.add(makeEvent(144, 9, key, 100, i));
                track.add(makeEvent(128, 9, key, 100, i + 1));
            } // end if
        } // end for
    } // end makeTracks method

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    } // end makeEvent method

    private void saveFile(File file) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < 256; i++) {
                JCheckBox check = (JCheckBox) checkboxList.get(i);
                if (check.isSelected()) writer.write("1\n");
                else writer.write("0\n");
            } // end loop
            writer.close();
        } catch (IOException ex) {
            System.out.println("couldn't write the track out");
            ex.printStackTrace();
        }
    } // end saveFile method

    private void loadFile(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            for (int i = 0; i < 256; i++) {
                JCheckBox check = (JCheckBox) checkboxList.get(i);
                if ((line = reader.readLine()) == "1") {
                    check.setSelected(true);
                } else {
                    check.setSelected(false);
                }
            } // end loop
            reader.close();
            sequencer.stop();
            buildTrackAndStart();
        } catch (IOException ex) {
            System.out.println("couldn't read the track file");
            ex.printStackTrace();
        } // try-catch
    } // end loadFile method
} // end BeatBox outer class

