package file.zip;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * ZipReader reads the zip file specified using ZipInputStream,
 * it then outputs the raw files into the output directory specified as a parameter.
 */
public class ZipReader {
    private static final Logger LOGGER = Logger.getLogger("ZipReader");

    // Expands the zip file passed as argument 1, into the directory provided in argument 2
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            LOGGER.severe("zipreader zipfile outputdir");
            return;
        }
        byte[] buffer = new byte[8 * 1024]; // create a buffer to improve copy performance later.

        Path outDir = Paths.get(args[1]);
        if (!Files.isDirectory(outDir)) Files.createDirectory(outDir);
        try (ZipInputStream stream = new ZipInputStream(new FileInputStream(args[0]))) {
            LOGGER.info("Zip file: " + args[0] + " has been opened");
            ZipEntry entry;
            while ((entry = stream.getNextEntry()) != null) {

                String fileInfo = String.format("Entry: [%s] len %d added %TD",
                        entry.getName(), entry.getSize(), new Date(entry.getTime()));
                LOGGER.info(fileInfo);

                Path filePath = outDir.resolve(entry.getName());
                if (entry.getSize() > 0) {
                    // Now we can read the file data from the stream. We now treat the stream like a usual
                    // input stream reading from it until it returns 0 or less.
                    try (FileOutputStream output = new FileOutputStream(filePath.toFile())) {
                        LOGGER.info("Writing file: " + filePath);
                        int len;
                        while ((len = stream.read(buffer)) > 0) output.write(buffer, 0, len);
                    }
                }
            }
        }
    }
}