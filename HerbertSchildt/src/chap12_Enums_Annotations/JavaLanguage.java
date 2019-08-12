/*
https://habr.com/ru/post/321152/
 */
package chap12_Enums_Annotations;

public enum JavaLanguage {
    JAVA("Forever"), SCALA("Next generation") {}, KOTLIN("Future") {};
    private final String claim;

    JavaLanguage(String claim) {
        this.claim = claim;
    }

    public String getClaim() {
        return claim;
    }

    public static void main(String[] args) {
        // it's true
        if (JAVA.getClass() == SCALA.getClass().getSuperclass())
            System.out.println("Наследник то есть: " + JAVA.getClass().getSuperclass());

        // it's true
        if (JAVA.getClass() == KOTLIN.getClass().getSuperclass())
            System.out.println("Да не один!");
    }
}
