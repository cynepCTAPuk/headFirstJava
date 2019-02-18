//: typeinfo/pets/ForNameCreator.java
package chap14_typeinfo.pets;
import java.util.*;
public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types =
            new ArrayList<Class<? extends Pet>>();
    // Types that you want to be randomly created:
    private static String[] typeNames = {
            "chap14_typeinfo.pets.Mutt",
            "chap14_typeinfo.pets.Pug",
            "chap14_typeinfo.pets.EgyptianMau",
            "chap14_typeinfo.pets.Manx",
            "chap14_typeinfo.pets.Cymric",
            "chap14_typeinfo.pets.Rat",
            "chap14_typeinfo.pets.Mouse",
            "chap14_typeinfo.pets.Hamster"
    };
    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for(String name : typeNames)
                types.add(
                        (Class<? extends Pet>)Class.forName(name));
        } catch(ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    static { loader(); }
    public List<Class<? extends Pet>> types() {return types;}
} ///:~