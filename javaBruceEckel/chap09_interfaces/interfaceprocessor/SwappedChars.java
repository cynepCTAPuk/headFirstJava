package chap09_interfaces.interfaceprocessor;

class SwappedChars extends StringProcessor {
    public String process(Object input) {
        String string = (String) input;
        String newstring = "";
        int size = string.length();
        if (size < 2) return string;
        for (int i = 1; i < size; i = i + 2) {
            newstring = newstring + string.charAt(i) + string.charAt(i - 1);
        }
        if (size % 2 != 0) newstring = newstring + string.charAt(size - 1);
        return newstring;
    }

    public static void main(String[] args) {
        SwappedChars swappedChars = new SwappedChars();
        System.out.println(swappedChars.process("1234567"));
    }
}
