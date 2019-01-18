package chap09_interfaces.interfaceprocessor;

class Downcase extends StringProcessor {
    public String process(Object input) {
        return ((String)input).toLowerCase();
    }
}
