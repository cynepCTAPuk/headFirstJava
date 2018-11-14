public class CustomHolderTest {
    public static void main(String args[]) {
        CustomHolder<String> stringHolder = new CustomHolder<String>();
        CustomHolder<Object> objectHolder = new CustomHolder<Object>();
        String str = new String("test string");

        stringHolder.putItem(str);
        objectHolder.putItem(str);

        String str2 = stringHolder.getItem(); // str2 = stringHolder.getItem()
        String str3 = (String)objectHolder.getItem(); // str3 = objectHolder.getItem()

        System.out.println("str " + str);
        System.out.println("stringHolder " + stringHolder.toString());
        System.out.println("objectHolder " + objectHolder.toString());
        System.out.println("str2 " + str2);
        System.out.println("str3 " + str3);
    }
}

class CustomHolder<E> {
    E storedItem;

    public E getItem() {
        return (storedItem);
    }

    public void putItem(E item) {
        System.out.println("Adding data of type " + item.getClass().getName());
        storedItem = item;
    }
}