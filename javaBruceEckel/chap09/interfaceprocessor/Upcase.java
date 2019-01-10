package chap09.interfaceprocessor;

class Upcase extends StringProcessor {
    public String process(Object input) { // Covariant return
        return ((String) input).toUpperCase();
    }
}
