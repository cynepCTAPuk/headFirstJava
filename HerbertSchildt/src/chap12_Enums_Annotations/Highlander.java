package chap12_Enums_Annotations;

public enum Highlander {
    JAVA;

    Highlander() {
        if (ordinal() != 0) throw new IllegalStateException("В живых должен остаться только один");
        init();
    }

    private void init() {
        // код здесь!
    }

    /**
     * java-doc
     */
    public String getOwner(String index) {
        // логика здесь
        return "Джеймс Гослинг, Sun Microsystems";
    }
}