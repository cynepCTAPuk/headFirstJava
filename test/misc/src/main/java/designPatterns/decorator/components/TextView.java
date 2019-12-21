package designPatterns.decorator.components;

public class TextView implements Component {
    @Override
    public void draw() {
        System.out.println("Draw TextView");
    }
}
