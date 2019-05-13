package chap01_strategy;

public class QuackMute implements QuackBehavior {
    public void quack() {
        System.out.println("<<Silence>>");
    }
}
