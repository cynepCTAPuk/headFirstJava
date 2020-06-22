package storage;

public class SingleBox implements IBox {
    private String array[];
    int size;

    public SingleBox() {
        array = new String[0];
        size = 0;
    }

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
        String[] newArray = new String[size() + 1];
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
        for (int i = 0; i < size(); i++) {
            if (size != 0) return true;
        }
        return false;
    }
}
