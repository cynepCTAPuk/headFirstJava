package chap09_interfaces.interfaceprocessor;

class Upcase extends StringProcessor {
    public String process(Object input) { // Covariant return
        return ((String) input).toUpperCase();
    }
}
