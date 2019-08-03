package chap09_Package_Interface;

/* Create an interface variable and
access stacks through it.
 */
class IFTest3 {
    public static void main(String[] args) {
        IntStack mystack; // create an interface reference variable
        DynStack ds = new DynStack(5);
        FixedStack fs = new FixedStack(8);

        mystack = ds; // load dynamic stack
        for (int i = 0; i < 12; i++) mystack.push(i);

        mystack = fs; // load fixed stack
        for (int i = 0; i < 8; i++) mystack.push(i);

        mystack = ds;
        System.out.println("\nValues in dynamic stack:");
        for (int i = 0; i < 12; i++) System.out.print(mystack.pop() + " ");

        mystack = fs;
        System.out.println("\nValues in fixed stack:");
        for (int i = 0; i < 8; i++) System.out.print(mystack.pop() + " ");
    }
}
