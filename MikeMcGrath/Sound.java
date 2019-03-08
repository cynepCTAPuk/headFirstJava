import javax.swing.*;
import java.awt.event.*;

public class Sound extends JFrame implements ActionListener {
    JPanel pnl = new JPanel();
    ClassLoader ldr = this.getClass().getClassLoader();
    java.applet.AudioClip audio = JApplet.newAudioClip(ldr.getResource("music.wav"));
    JButton playBtn = new JButton("Играть");
    JButton stopBtn = new JButton("Стоп");

    public Sound() {
        super("Окно Swing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        add(pnl);
        pnl.add( playBtn ) ;
        pnl.add( stopBtn ) ;
        playBtn.addActionListener( this ) ;
        stopBtn.addActionListener( this ) ;

        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if ( event.getSource() == playBtn ) audio.play() ;
        if ( event.getSource() == stopBtn ) audio.stop() ;
    }

    public static void main(String[] args) {
        Sound gui = new Sound();
    }
}
