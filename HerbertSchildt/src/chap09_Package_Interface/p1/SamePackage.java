package chap09_Package_Interface.p1;

class SamePackage {
    SamePackage() {
        Protection p = new Protection();
        System.out.println("same package constructor");
        System.out.println("n = " + p.n);
    }

    public static void main(String[] args) {
        SamePackage samePackage = new SamePackage();
    }
}
