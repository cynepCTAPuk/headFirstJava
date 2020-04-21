public static Animal[] deserializeAnimalArray(byte[] data) {
    Animal[] heap = new Animal[0];
    ByteArrayInputStream bais = new ByteArrayInputStream(data);
    try (ObjectInputStream ois = new ObjectInputStream(bais)) {
        int size = ois.readInt();
        heap = new Animal[size];
        for (int i = 0; i < size; i++) {
            heap[i] = (Animal) ois.readObject();
        }
    } catch (Exception e) {
        throw new IllegalArgumentException();
    }
    return heap;
}