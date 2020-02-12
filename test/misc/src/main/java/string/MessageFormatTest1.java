package string;

import java.text.MessageFormat;
import java.util.Date;

public class MessageFormatTest1 {
    public static void main(String[] args) {
        int fileCount = 1273;
        String diskName = "MyDisk";
        Object[] testArgs = {fileCount, diskName};

        MessageFormat form = new MessageFormat("The disk \"{1}\" contains {0} file(s).");

        System.out.println(form.format(testArgs));
    }
}
