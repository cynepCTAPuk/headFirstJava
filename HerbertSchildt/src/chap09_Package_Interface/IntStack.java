package chap09_Package_Interface;

// 1) Define an integer stack interface
// 2) Another version of IntStack that has a private interface method that is used by two default methods

interface IntStack {
    void push(int item); // store an item

    int pop(); // retrieve an item

    // Because clear() has a default, it need not be
    // implemented by a preexisting class that uses IntStack.
    default void clear() {
        System.out.println("clear() not implemented");
        throw new UnsupportedOperationException();
    }

    // A default method that returns an array that contains the top n elements on the stack
    default int[] popNElements(int n) {
        // Return the requested elements
        return getElements(n);
    }

    default int[] skipAndPopNElements(int skip, int n) {
        getElements(skip);
        return getElements(n);
    }

    private int[] getElements(int n) {
        int[] elements = new int[n];
        for (int i = 0; i < n; i++) elements[i] = pop();
        return elements;
    }
}
