package patterns.decorator;

import patterns.decorator.components.Component;
import patterns.decorator.components.TextView;
import patterns.decorator.components.Window;
import patterns.decorator.decorators.BorderDecorator;
import patterns.decorator.decorators.ColorDecorator;

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
