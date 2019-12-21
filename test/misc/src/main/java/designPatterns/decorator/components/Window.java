package designPatterns.decorator.components;

public class Window implements Component {
    @Override
    public void draw() {
        System.out.println("Draw Window");
    }
}
