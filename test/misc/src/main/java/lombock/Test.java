package lombock;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
/*
        User user = new User();
        user.setFirstName("Ivan");
        user.setSecondName("Ivanovich");
        user.setLastName("Ivanov");
        user.setAge(33);
        System.out.println(user);
*/

/*
        User user1 = new User("Alexander", "Sergeevich", "Pushkin", 37);
        System.out.println(user1);
*/

//        for (Method method : user.getClass().getMethods()) System.out.println(method);
//        Arrays.stream(user.getClass().getMethods()).sorted(Comparator.comparing(Method::getName)).forEach(System.out::println);
//        Arrays.stream(user.getClass().getDeclaredFields()).forEach(System.out::println);
//        Arrays.stream(new User().getClass().getDeclaredMethods()).forEach(System.out::println);
//        Arrays.stream(new User().getClass().getDeclaredConstructors()).forEach(System.out::println);

        List<User> users = new ArrayList<>();
        users.add(new User("A", "A", "A", 10));
        users.add(new User("B", "B", "B", 20));
        users.add(new User("C", "C", "C", 30));

//        System.out.println(users);
//        users.stream().forEach(System.out::println);

//        users.stream().filter(o -> o.getAge() > 10 & o.getAge() < 30).forEach(System.out::println);
        List<User> filtered = users.stream()
                .filter(user -> user.getAge() > 10)
                .filter(user -> user.getAge() < 30)
                .collect(Collectors.toList());
        System.out.println(filtered);
    }
}
