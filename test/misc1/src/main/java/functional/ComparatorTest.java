//https://www.java67.com/2014/11/java-8-comparator-example-using-lambda-expression.html
package functional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
    public static void main(String[] args) {
        // List of training courses, our target is to sort these courses based upon their price or title
        List<TrainingCourses> onlineCourses = new ArrayList<>();
        onlineCourses.add(new TrainingCourses("Spring", new BigDecimal("200")));
        onlineCourses.add(new TrainingCourses("Scala", new BigDecimal("300")));
        onlineCourses.add(new TrainingCourses("Java", new BigDecimal("200")));
        onlineCourses.add(new TrainingCourses("NoSQL", new BigDecimal("310")));
        System.out.println("----------List of training courses, before sorting\n" + onlineCourses);

        // Comparator to compare Price of training courses
/*
        final Comparator<TrainingCourses> PRICE_COMPARATOR = new Comparator<>() {
            @Override
            public int compare(TrainingCourses t1, TrainingCourses t2) {
                return t1.price().compareTo(t2.price());
            }
        };
*/
//        final Comparator<TrainingCourses> PRICE_COMPARATOR = (t1, t2) -> t1.price().compareTo(t2.price());
        final Comparator<TrainingCourses> PRICE_COMPARATOR = Comparator.comparing(TrainingCourses::price);
        // Comparator to compare Title of training courses
/*
        final Comparator<TrainingCourses> TITLE_COMPARATOR = new Comparator<>() {
            @Override
            public int compare(TrainingCourses c1, TrainingCourses c2) {
                return c1.title().compareTo(c2.title());
            }
        };
*/
//        final Comparator<TrainingCourses> TITLE_COMPARATOR = (c1, c2) -> c1.title().compareTo(c2.title());
        final Comparator<TrainingCourses> TITLE_COMPARATOR = Comparator.comparing(TrainingCourses::title);

        // Sorting objects using Comparator by Price
//        Collections.sort(onlineCourses, PRICE_COMPARATOR);
        onlineCourses.sort(PRICE_COMPARATOR);
        System.out.println("----------Sorting list by price, increasing order\n" + onlineCourses);
        onlineCourses.sort(PRICE_COMPARATOR.reversed());
        System.out.println("----------Sorting list by price, reversed increasing order\n" + onlineCourses);
        onlineCourses.sort(PRICE_COMPARATOR.reversed().thenComparing(TITLE_COMPARATOR));
        System.out.println("----------Sorting list by price, reversed increasing order then comparing by title\n" + onlineCourses);

        // Sorting objects using Comparator by Title
//        Collections.sort(onlineCourses, TITLE_COMPARATOR);
        onlineCourses.sort(TITLE_COMPARATOR);
        System.out.println("----------Sorting list by title\n" + onlineCourses);

        // Now let's see how less code you need to write if you use lambda expression from Java 8,
        // in place of anonymous class we don't need an extra line to declare comparator, we can
        // provide them in place to sort() method.
//        Collections.sort(onlineCourses, (c1, c2) -> c2.price().compareTo(c1.price()));
        onlineCourses.sort((c1, c2) -> c1.price().compareTo(c2.price()));
        System.out.println("----------Sorting objects in increasing order of price, using lambdas\n" + onlineCourses);
//        Collections.sort(onlineCourses, (c1, c2) -> c2.title().compareTo(c1.title()));
        onlineCourses.sort((c1, c2) -> c1.title().compareTo(c2.title()));
        System.out.println("----------Sorting list in increasing order of title, using lambdas\n" + onlineCourses);
    }
}

class TrainingCourses {
    private final String title;
    private final BigDecimal price;

    public TrainingCourses(String title, BigDecimal price) {
        super();
        this.title = title;
        this.price = price;
    }

    public String title() {
        return title;
    }

    public BigDecimal price() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s : %s", title, price);
    }
}
