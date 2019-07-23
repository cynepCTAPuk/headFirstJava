import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class Central_Pixels_Finder extends Image {
    public int[] central_pixels(int colour) {
        return new int[0];
    }
    @Override
    public int getWidth(ImageObserver observer) {
        return 0;
    }
    @Override
    public int getHeight(ImageObserver observer) {
        return 0;
    }
    @Override
    public ImageProducer getSource() {
        return null;
    }
    @Override
    public Graphics getGraphics() {
        return null;
    }
    @Override
    public Object getProperty(String name, ImageObserver observer) {
        return null;
    }
    public static void main(String[] args) {

    }
}