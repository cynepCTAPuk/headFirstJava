class FibonacciIterator implements Iterator<Integer> {
    @Override
    public boolean hasNext() {
        // enter your code
        return false;
    }

    @Override
    public Integer next() {
        // enter your code
        return null;
    }

}

class FibonacciIterable implements Iterable<Integer> {
    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator();
    }
}