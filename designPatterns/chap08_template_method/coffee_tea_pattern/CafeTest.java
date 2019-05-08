package chap08_template_method.coffee_tea_pattern;

public class CafeTest {
    public static void main(String[] args) {
        Tea tea = new Tea();
        tea.prepareRecipe();

        Coffee coffee = new Coffee();
        coffee.prepareRecipe();
    }
}
