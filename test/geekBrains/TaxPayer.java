public class TaxPayer extends Person {
    int salary = 20_000;
    int savings;

    void work() {
        savings += salary;
    }

    @Override
    public void print() {
//        System.out.println("This is " + this.name + " and " +
//        (this.sex ? "he" : "she")+ " is " + this.age + " years old.
//        Salary is " + salary + " rubs/month."+ " Saving is " + savings + " rub.");
        super.print();
        System.out.println(", " +
                (this.sex ? "he" : "she") + " earns " + salary + " rubs/month, " +
                (this.sex ? "he" : "she") + " has saved " + savings + " rub.");
    }
}
