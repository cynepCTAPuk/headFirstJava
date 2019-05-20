package chap11_proxy.virtualproxy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

public class ImageProxyTestDrive2 {
    ImageComponent imageComponent;
    JFrame frame = new JFrame("CD Cover Viewer");
    JMenuBar menuBar;
    JMenu menu;
    TreeMap<String, String> treeMap = new TreeMap<>();

    public static void main(String[] args) throws Exception {
        ImageProxyTestDrive2 testDrive = new ImageProxyTestDrive2();
    }

    public ImageProxyTestDrive2() throws Exception {
        treeMap.put("Buddha Bar", "http://images.amazon.com/images/P/B00009XBYK.01.LZZZZZZZ.jpg");
        treeMap.put("Ima", "http://images.amazon.com/images/P/B000005IRM.01.LZZZZZZZ.jpg");
        treeMap.put("Karma", "http://images.amazon.com/images/P/B000005DCB.01.LZZZZZZZ.gif");
        treeMap.put("MCMXC A.D.", "http://images.amazon.com/images/P/B000002URV.01.LZZZZZZZ.jpg");
        treeMap.put("Northern Exposure", "http://images.amazon.com/images/P/B000003SFN.01.LZZZZZZZ.jpg");
        treeMap.put("Selected Ambient Works, Vol. 2", "http://images.amazon.com/images/P/B000002MNZ.01.LZZZZZZZ.jpg");

        URL initialURL = new URL(treeMap.get("Selected Ambient Works, Vol. 2"));
        menuBar = new JMenuBar();
        menu = new JMenu("Favorite CDs");
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        for(Map.Entry<String,String> entry : treeMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            JMenuItem jMenuItem = new JMenuItem(key);
            menu.add(jMenuItem);
            jMenuItem.addActionListener(event -> {
                imageComponent.setIcon(new ImageProxy(
                        ImageProxyTestDrive2.this.getCDUrl(event.getActionCommand())));
                frame.repaint();
            });
//            System.out.println(key + " => " + value);
        }

        // set up frame and menus
        Icon icon = new ImageProxy(initialURL);
        imageComponent = new ImageComponent(icon);
        frame.getContentPane().add(imageComponent);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    URL getCDUrl(String name) {
        try {return new URL(treeMap.get(name));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
