/*
https://habr.com/ru/post/321152/
 */
package chap12_Enums_Annotations;

public enum LanguageUtils {
    ;

    /**
     * java-doc
     */
    LanguageUtils() {
        throw new IllegalStateException("Это не перечисление");
    }

    /**
     * java-doc
     */
    public static String[] getKeyWords(String languageName) {
        if (languageName != null) {
            // немного логики здесь
            return loadFromResource(languageName + "/keywords.dat");
        }
        throw new IllegalStateException("Необходимо указать язык");
    }

    /**
     * java-doc
     */
    private static synchronized String[] loadFromResource(String resourceName) {
        String[] items = null;
        // Код загрузки здесь
        return items;
    }
    /** Много статических методов здесь */
}
