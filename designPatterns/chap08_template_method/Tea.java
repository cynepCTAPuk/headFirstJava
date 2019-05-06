package chap08_template_method;

public class Tea extends CaffeineBeverage {
    @Override
    public void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    void addCondements() {
        System.out.println("Adding Lemon");
    }
}
