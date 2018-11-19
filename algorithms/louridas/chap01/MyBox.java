package louridas.chap01;

import java.util.ArrayList;

public class MyBox<T> {
  public T box;

  public MyBox() {
  }

  public MyBox(T box) {
    this.box = box;
  }

  public static void main(String[] args) {
    MyBox myBox = new MyBox();
    System.out.println(myBox.toString() + " " + myBox.box);

    MyBox<Integer> integerMyBox = new MyBox<>(10);
    System.out.println(integerMyBox.toString() + " " + integerMyBox.box);

    MyBox<String> stringMyBox = new MyBox<>("Hello Java!");
    System.out.println(stringMyBox.toString() + " " + stringMyBox.box);

    ArrayList<MyBox<Integer>> arrayList = new ArrayList<>(5);
    arrayList.add(new MyBox<Integer>(1));
    arrayList.add(new MyBox<Integer>(2));
    System.out.println(arrayList);
  }
}

