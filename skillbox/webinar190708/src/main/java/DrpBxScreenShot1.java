import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DrpBxScreenShot1 {

    public static void main(String args[])
            throws DbxException, IOException, AWTException, InterruptedException {
        @SuppressWarnings("deprecation")
        DbxRequestConfig config = new DbxRequestConfig("screen_shot", "en_US");
        DbxClientV2 client = new DbxClientV2(config, Screenshot.ACCESS_TOKEN);
        int i = 0;

        while (i < 10) {
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String fileDrpBx = dateFormat.format(new Date()) + ".png";
            String fileLocal = "C:/0/" + fileDrpBx;
            System.out.print(i++ + " ");

            BufferedImage image = new Robot().createScreenCapture(
                    new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(image, "png", new File(fileLocal));

            try (InputStream is = new FileInputStream(fileLocal)) {
                FileMetadata metadata = client.files()
                        .uploadBuilder("/" + fileDrpBx).uploadAndFinish(is);
            }
            Thread.sleep(5_000);

        }
    }
}