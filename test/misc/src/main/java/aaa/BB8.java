package aaa;

class BB100 {
    public static void main(String[] args) {
        System.out.println("BB100 main method");
    }
}

class BB8 {
    public static void main(String[] args) {
        System.out.println("BB8 main method");
        BB100.main(new String[99]);
    }
}
