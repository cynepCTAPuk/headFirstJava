import javax.imageio.ImageIO;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot {
    public static void main(String[] args) throws AWTException, IOException {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        System.out.println(dateFormat.format(new Date()));
        String fileName = "C:/0/" + dateFormat.format(new Date()) + ".png";

        BufferedImage image = new Robot().createScreenCapture(
                new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

        ImageIO.write(image, "png", new File(fileName));

        System.out.println(" width: " + image.getWidth());
        System.out.println("height: " + image.getHeight());
    }
}
