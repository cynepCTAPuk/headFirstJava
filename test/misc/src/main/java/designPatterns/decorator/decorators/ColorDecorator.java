package designPatterns.decorator.decorators;

import designPatterns.decorator.components.Component;

public class ColorDecorator extends Decorator {
    public ColorDecorator(Component component) {
        super(component);
    }

    @Override
    public void afterDraw() {
        System.out.println("... add color");
    }
}
