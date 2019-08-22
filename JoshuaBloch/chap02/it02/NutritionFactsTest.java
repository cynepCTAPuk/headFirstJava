package chap02.it02;

public class NutritionFactsTest {
    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                .calories(100)
//                .fat(0)
                .sodium(35)
                .carbohydrate(27)
                .build();
        System.out.println(cocaCola);

//        can't use it, because Constructor is private
//        NutritionFacts nutritionFacts = new NutritionFacts(
//                new NutritionFacts.Builder(100, 50).calories(50));
    }

}
