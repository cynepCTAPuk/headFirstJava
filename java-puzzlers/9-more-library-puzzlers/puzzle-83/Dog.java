class Dog2 extends Exception {
    public static final Dog2 INSTANCE = new Dog2();
    private Dog2() { }

    public String toString() {
        return "Woof";
    }
}
