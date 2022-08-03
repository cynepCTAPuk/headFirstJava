package reflection;

import java.lang.reflect.Field;

public class StringField {
    public static void main(String[] args) throws Exception {
        String value = "Old value";
        System.out.println(value);

        //Получаем поле value в классе String
        Field field = value.getClass().getDeclaredField("value");
        //Разрешаем изменять его
        field.setAccessible(true);
        //Устанавливаем новое значение
//        field.set(value, "JavaRush".toCharArray()); // not for openjdk13
        field.set(value, "JavaRush".getBytes());

        System.out.println(value);

        /* Вывод:
         * Old value
         * JavaRush
         */
    }
}
