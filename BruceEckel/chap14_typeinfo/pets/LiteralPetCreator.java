//: typeinfo/pets/LiteralPetCreator.java
// Using class literals.
package chap14_typeinfo.pets;
import java.util.*;
public class LiteralPetCreator extends PetCreator {
    // No try block needed.
    @SuppressWarnings("unchecked")
    public static final List<Class<? extends Pet>> allTypes =
            Collections.unmodifiableList(Arrays.asList(
                    Pet.class, Dog.class, Cat.class, Rodent.class,
                    Mutt.class, Pug.class, EgyptianMau.class, Manx.class,
                    Cymric.class, Rat.class, Mouse.class,Hamster.class));
    // Types for random creation:
    private static final List<Class<? extends Pet>> types =
            allTypes.subList(allTypes.indexOf(Mutt.class),
                    allTypes.size());
    public List<Class<? extends Pet>> types() {
        return types;
    }
    public static void main(String[] args) {
        System.out.println(types);
    }
} /* Output:
[class chap14_typeinfo.pets.Mutt, class chap14_typeinfo.pets.Pug, class chap14_typeinfo.pets.EgyptianMau, class chap14_typeinfo.pets.Manx, class chap14_typeinfo.pets.Cymric, class chap14_typeinfo.pets.Rat, class chap14_typeinfo.pets.Mouse, class chap14_typeinfo.pets.Hamster]
*///:~