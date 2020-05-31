package resources;

@SuppressWarnings("UnusedDeclaration")
public interface ResourceServerMBean {
    String getName();

    int getAge();

    void setName(String name);

    void setAge(int age);
}
