import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DrpBxScreenShot2 {

    public static void main(String args[])
            throws DbxException, IOException, AWTException, InterruptedException {
        @SuppressWarnings("deprecation")
        DbxRequestConfig config = new DbxRequestConfig("screen_shot", "en_US");
        DbxClientV2 client = new DbxClientV2(config, Screenshot.ACCESS_TOKEN);

        while (true) {
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String fileDrpBx = dateFormat.format(new Date()) + ".png";

            Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage image = new Robot().createScreenCapture(rectangle);

            ByteArrayOutputStream baops = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baops);

            try (InputStream is = new ByteArrayInputStream(baops.toByteArray())) {
                FileMetadata metadata = client.files()
                        .uploadBuilder("/" + fileDrpBx).uploadAndFinish(is);
            }
            Thread.sleep(5_000);

        }
    }
}