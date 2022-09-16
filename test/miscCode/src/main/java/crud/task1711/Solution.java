package crud.task1711;

import crud.Person;
import crud.Sex;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
//        printAllPeople();

        if (args.length > 0) {
            switch (args[0]) {
                case "-c":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i += 3) {
                            String name = args[i];
                            String sex = args[i + 1];
                            String bd = args[i + 2];
                            Date birthday = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(bd);
                            if (sex.equals("ж")) allPeople.add(Person.createFemale(name, birthday));
                            else if (sex.equals("м")) allPeople.add(Person.createMale(name, birthday));
                            System.out.println(allPeople.size() - 1);
                        }
                    }
                    break;
                case "-u":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i += 4) {
                            int id = Integer.parseInt(args[i]);
                            String name = args[i + 1];
                            String sex = args[i + 2];
                            String bd = args[i + 3];
                            Date birthday = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(bd);
                            if (sex.equals("ж")) allPeople.set(id, Person.createFemale(name, birthday));
                            else if (sex.equals("м")) allPeople.set(id, Person.createMale(name, birthday));
                        }
                    }
                    break;
                case "-d":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            int id = Integer.parseInt(args[i]);
                            Person p = allPeople.get(id);
                            p.setName(null);
                            p.setSex(null);
                            p.setBirthDate(null);
                            allPeople.set(id, p);
                        }
                        break;
                    }
                case "-i":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            Person p = allPeople.get(Integer.parseInt(args[i]));
                            Sex sex = p.getSex();
                            String pol = "";
                            if (sex.equals(Sex.FEMALE)) pol = "ж";
                            else if (sex.equals(Sex.MALE)) pol = "м";
                            String bd = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(p.getBirthDate());
                            System.out.println(p.getName() + " " + pol + " " + bd);
                        }
                    }
                    break;
            }
        }
//        printAllPeople();
    }

    private static void printAllPeople() {
        List<String> list = new ArrayList<>();
        for (Person p : allPeople) {
            Sex sex = p.getSex();
            String pol = "null";
            Date birthDate = p.getBirthDate();
            String bd = "null";
            if (sex != null && sex.equals(Sex.FEMALE)) pol = "ж";
            else if (sex != null && sex.equals(Sex.MALE)) pol = "м";
            if (birthDate != null)
                bd = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(birthDate);
            list.add(p.getName() + " " + pol + " " + bd);
        }
        System.out.println(String.join("; ", list));
    }
}
