package chap09_Collections.enumSet;

/**
 * A minimalist employee class for testing purposes.
 */
public class Employee {
    private String name;

    /**
     * Constructs an employee with $0 salary.
     *
     * @param name the employee name
     */
    public Employee(String name) {
        this.name = name;
    }

    public String toString() {
        return "[name=" + name + "]";
    }
//    public String toString() {return "name:" + name + ", salary:" + salary;}
}
