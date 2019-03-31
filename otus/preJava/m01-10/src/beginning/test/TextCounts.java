package beginning.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextCounts {

    public static void main(String[] args) throws IOException {

        FileReader file = new FileReader("inputDE.txt"); // datei lesen

        BufferedReader reader = new BufferedReader(file);
        int sentenceCount = 0;
        String line;
        String[] singlePointExceptions = {
                "19. Jahrhundert", "allg.", "bzw.", "bspw.", "etc.", "evtl.", "geb.", "ggf.", "n.Chr", "od.", "s.", "u.", "usw.", "vgl."
        };
        String[] doublePointExceptions = {
                "b.w.", "d.h.", "d.i", "n.Chr.", "s.a.", "s.o.", "s.u.", "u.a.", "u.Ä.", "u.U.", "u.z.", "v.a.", "v.Chr.", "z.B.", "z.T.", "z.Zt."
        };

        while ((line = reader.readLine()) != null) { // Continue reading until end of file is reached
            int countQuestionsAndExclamations = countMatchesOfSpecialCharacters(line, "?", "!");
            int countSingles = countMatchesOfSpecialCharacters(line, singlePointExceptions);
            int countDoubles = countMatchesOfSpecialCharacters(line, doublePointExceptions);
            int countPoints = countMatchesOfSpecialCharacters(line, "");

            sentenceCount += (countQuestionsAndExclamations + (countPoints - (countSingles + countDoubles)));
        }

        reader.close();
        file.close();
        System.out.println("# of founded Sentences: " + sentenceCount);

    }

    private static int countMatchesOfSpecialCharacters(final String str, final String...specialCharacters) {
        if (null == str || str.isEmpty()) {
            return 0;
        }
        if (null == specialCharacters || specialCharacters.length == 0) {
            return 0;
        }
        int count = 0;
        int index;
        for (String special : specialCharacters) {
            index = 0;
            while ((index = str.indexOf(special, index)) != -1) {
                count++;
                index += special.length();
                if (index >= str.length()) {
                    break;
                }
            }
        }

        return count;
    }
}