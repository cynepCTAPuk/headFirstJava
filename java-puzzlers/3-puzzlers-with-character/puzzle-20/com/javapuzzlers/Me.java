package com.javapuzzlers;

public class Me {
   public static void main(String[] args) {
      System.out.println(
              Me.class.getName().replaceAll(".", "/") + ".class");
      System.out.println(Me.class.getName());

      System.out.println("Never Say Never Again".replaceAll("e","^"));
   }
}
