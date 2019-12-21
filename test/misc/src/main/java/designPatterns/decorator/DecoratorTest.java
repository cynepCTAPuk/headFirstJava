package designPatterns.decorator;

import designPatterns.decorator.components.Component;
import designPatterns.decorator.components.TextView;
import designPatterns.decorator.components.Window;
import designPatterns.decorator.decorators.BorderDecorator;
import designPatterns.decorator.decorators.ColorDecorator;

public class DecoratorTest {
    public static void main(String[] args) {
        Component borderTextView = new BorderDecorator(new TextView());
        borderTextView.draw();
        Component colorWindow = new ColorDecorator(new Window());
        colorWindow.draw();
        Component colorBorderTextView = new ColorDecorator(new BorderDecorator(new TextView()));
        colorBorderTextView.draw();
        Component borderColorTextView = new BorderDecorator(new ColorDecorator(new TextView()));
        borderColorTextView.draw();

        colorBorderTextView = new ColorDecorator(borderColorTextView);
    }
}
