package designPatterns;

public class UIControlTest {
    public static void main(String[] args) {
        drawUIControl(new TextBox());
    }

    private static void drawUIControl(UIControl control) {
        control.draw();
    }
}
