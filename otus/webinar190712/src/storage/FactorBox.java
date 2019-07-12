package storage;

public class FactorBox implements IBox {
    static final int INIT_SIZE = 10;
    static final int FACTOR = 50; // percent %
    private String[] array;
    private int size;

    public FactorBox() {
        array = new String[INIT_SIZE];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(String item) {
        if (size() == array.length) resize();
        array[size] = item;
        size++;
    }

    private void resize() {
        String[] newArray = new String[array.length + array.length * FACTOR / 100];
        System.arraycopy(array, 0, newArray, 0, size());
//        for (int i = 0; i < size() ; i++) newArray[i] = array[i];
        array = newArray;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index > size()) throw new ArrayIndexOutOfBoundsException();
        return array[index];
    }

    @Override
    public boolean has(String item) {
        for (int i = 0; i < size() ; i++) {
            if(size!=0) return true;
        }
        return false;
    }
}
