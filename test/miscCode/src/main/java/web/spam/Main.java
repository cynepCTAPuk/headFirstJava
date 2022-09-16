package web.spam;

public class Main {
    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer t : analyzers) {
            Label label = t.processText(text);
            if (label != Label.OK) return label;
        }
        return Label.OK;
    }

    public static void main(String[] args) {
        TextAnalyzer[] analyzers = {
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(new String[]{"fuck"}),
                new TooLongTextAnalyzer(10)
        };
        String text = "   :( ";

        System.out.println(new Main().checkLabels(analyzers, text));
    }
}
