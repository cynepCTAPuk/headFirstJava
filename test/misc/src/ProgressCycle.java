package src;

import java.io.IOException;

public class ProgressCycle {
  public static void main(String[] args) {
    String anim = "|/-\\";
    for (int i = 0; i < 100; i++) {
      String data = "\r" + anim.charAt(i % anim.length()) + " " + i;
      try {
        System.out.write(data.getBytes());
        Thread.sleep(250);
      } catch (IOException | InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
