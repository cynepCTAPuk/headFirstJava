package chap08_template_method.coffee_tea_pattern;

public class Tea extends CaffeineBeverage {
    @Override
    public void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Lemon");
    }
}
