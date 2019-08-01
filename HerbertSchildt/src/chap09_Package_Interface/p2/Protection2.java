package chap09_Package_Interface.p2;

import chap09_Package_Interface.p1.Protection;

class Protection2 extends Protection {
    Protection2() {
        System.out.println("derived other package constructor");
//        class or package only
//        System.out.println("n = " + n);
//        class only
//        System.out.println("n_pri = " + n_pri);
        System.out.println("n_pro = " + n_pro);
        System.out.println("n_pub = " + n_pub);
    }

    public static void main(String[] args) {
        Protection2 protection2 = new Protection2();
    }
}
