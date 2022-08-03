package unsort;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class QuizCardBuilder {

    private JTextArea question;
    private JTextArea answer;
    private ArrayList cardList;
    private JFrame frame;
    
    // additional, bonus method not found in any book!

    public static void main (String[] args) {
       QuizCardBuilder builder = new QuizCardBuilder();
       builder.go();
    }
    
    public void go() {
        // build gui
        frame = new JFrame("Quiz Card Builder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // title bar
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 24);
        question = new JTextArea(6,20);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        question.setFont(bigFont);
       
        JScrollPane qScroller = new JScrollPane(question);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        answer = new JTextArea(6,20);
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);
        answer.setFont(bigFont);
       
        JScrollPane aScroller = new JScrollPane(answer);
        aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JButton nextButton = new JButton("Next Card");
        cardList = new ArrayList();
        JLabel qLabel = new JLabel("Question:");
        JLabel aLabel = new JLabel("Answer:");
        
        mainPanel.add(qLabel);
        mainPanel.add(qScroller);
        mainPanel.add(aLabel);
        mainPanel.add(aScroller);
        mainPanel.add(nextButton);

        nextButton.addActionListener(new NextCardListener());

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        newMenuItem.addActionListener(new NewMenuListener());
        saveMenuItem.addActionListener(new SaveMenuListener());
        exitMenuItem.addActionListener(new ExitMenuListener());

        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(500,600);
        frame.setVisible(true);        
    }

    public class NextCardListener implements ActionListener {
       public void actionPerformed(ActionEvent ev) {
          QuizCard card = new QuizCard(question.getText(), answer.getText());
          cardList.add(card);
          clearCard();
        }
     }

     public class SaveMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
           QuizCard card = new QuizCard(question.getText(), answer.getText());
           cardList.add(card);
       
           JFileChooser fileSave = new JFileChooser();
           fileSave.showSaveDialog(frame);
           saveFile(fileSave.getSelectedFile());
        }
     }

    public class NewMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
           cardList.clear();
           clearCard();           
        }
    }

    public class ExitMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
        	System.out.println("Button \"Exit\" was pressed!");
        	// exit programm
        }
    }
    
    private void clearCard() {
       question.setText("");
       answer.setText("");
       question.requestFocus();
    }

    private void saveFile(File file) {
         
       try {
          BufferedWriter writer = new BufferedWriter(new FileWriter(file));
          Iterator cardIterator = cardList.iterator();
          while (cardIterator.hasNext()) {
             QuizCard card = (QuizCard) cardIterator.next();
             writer.write(card.getQuestion() + "/");
             writer.write(card.getAnswer() + "\n");
          }
         writer.close();

       } catch(IOException ex) {
           System.out.println("couldn't write the cardList out");
           ex.printStackTrace();
       }
       
    } // close method
}