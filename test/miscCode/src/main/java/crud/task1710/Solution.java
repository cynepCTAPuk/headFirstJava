package crud.task1710;

import crud.Person;
import crud.Sex;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution implements List {
    public static volatile List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
//        for (Person p : allPeople) System.out.println(p.getName() + " " + p.getSex() + " " + p.getBirthDate());

        String first = "";
        if (args.length > 0) {
//            String arr = String.join(" ", args);
//            System.out.println(arr);
            first = args[0];
            if (first.equals("-c")) {
                String name = args[1];
                String sex = args[2];
                String bd = args[3];
                Date birthday = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(bd);
                if (sex.equals("ж")) allPeople.add(Person.createFemale(name, birthday));
                else if (sex.equals("м")) allPeople.add(Person.createMale(name, birthday));
                System.out.println(allPeople.size() - 1);
            } else if (first.equals("-u")) {
                int id = Integer.parseInt(args[1]);
                String name = args[2];
                String sex = args[3];
                String bd = args[4];
                Date birthday = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(bd);
                if (sex.equals("ж")) allPeople.set(id, Person.createFemale(name, birthday));
                else if (sex.equals("м")) allPeople.set(id, Person.createMale(name, birthday));
            } else if (first.equals("-d")) {
                int id = Integer.parseInt(args[1]);
                Person p = allPeople.get(id);
                p.setName(null);
                p.setSex(null);
                p.setBirthDate(null);
                allPeople.set(id, p);
            } else if (first.equals("-i")) {
                int id = Integer.parseInt(args[1]);
                Person p = allPeople.get(id);
                Sex sex = p.getSex();
                String pol = "";
                if (sex.equals(Sex.FEMALE)) pol = "ж";
                else if (sex.equals(Sex.MALE)) pol = "м";
                String bd = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(p.getBirthDate());
                System.out.println(p.getName() + " " + pol + " " + bd);
            }
        }
//        for (Person p : allPeople) System.out.println(p.getName() + " " + p.getSex() + " " + p.getBirthDate());
    }

    @Override
    public int size() {
        return allPeople.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
