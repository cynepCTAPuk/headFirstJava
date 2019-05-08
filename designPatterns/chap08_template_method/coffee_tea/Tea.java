package chap08_template_method.coffee_tea;

public class Tea {
    void prepareRecipe() {
        boilWater();
        steepTeaBag();
        pourInCup();
        addLemon();
    }
    public void boilWater() {
        System.out.println("Boiling water");
    }
    public void steepTeaBag() {
        System.out.println("Steeping the tea");
    }
    public void pourInCup() {
        System.out.println("Pouring into cup");
    }
    public void addLemon() {
        System.out.println("Adding Lemon");
    }
    public static void main(String[] args) {
        Tea tea = new Tea();
        tea.prepareRecipe();
    }
}