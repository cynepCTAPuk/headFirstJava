import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.WriteMode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DrpBxScreenShot3 {

    public static void main(String args[]) throws AWTException {
        DbxRequestConfig config = DbxRequestConfig.newBuilder("screen_shot").build();
        DbxClientV2 client = new DbxClientV2(config, Screenshot.ACCESS_TOKEN);

        while (true) {
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String fileDrpBx = dateFormat.format(new Date()) + ".png";

            Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage image = new Robot().createScreenCapture(rectangle);

            ByteArrayOutputStream baops = new ByteArrayOutputStream();

            try {
                ImageIO.write(image, "png", baops);
                try (InputStream is = new ByteArrayInputStream(baops.toByteArray())) {
                    FileMetadata metadata = client.files().uploadBuilder("/" + fileDrpBx)
                            .withMode(WriteMode.OVERWRITE).uploadAndFinish(is);
                } catch (DbxException e) {
                    e.printStackTrace();
                }
                Thread.sleep(5_000);
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}