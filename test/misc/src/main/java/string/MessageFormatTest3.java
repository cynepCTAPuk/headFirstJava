package string;

import java.text.ChoiceFormat;
import java.text.DateFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.util.Date;

public class MessageFormatTest3 {
    public static void main(String[] args) {
        MessageFormat pattform = new MessageFormat("There {0} on {1}.\n{2} {2}");
        int count = 1;
        Date date = new Date();

        double[] filelimits = {0, 1, 2};
        String[] filepart = {"are no files", "is one file", "are {0} files"};
        ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);

        Format[] testFormats
                = {
                fileform,
                null,
                DateFormat.getDateInstance(DateFormat.SHORT),
                DateFormat.getTimeInstance(DateFormat.SHORT)
        };
        pattform.setFormats(testFormats);

        Object[] testArgs = {count, "ADisk", date, date};
        System.out.println(pattform.format(testArgs));
    }
}
