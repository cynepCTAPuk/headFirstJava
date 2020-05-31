package resources;

public class ResourceServer implements ResourceServerMBean {
    private TestResource testResource;

    public ResourceServer(TestResource testResource) {
        this.testResource = testResource;
    }

    @Override
    public String getName() {
        return testResource.getName();
    }

    @Override
    public int getAge() {
        return testResource.getAge();
    }

    @Override
    public void setName(String name) {
        testResource.setName(name);
    }

    @Override
    public void setAge(int age) {
        testResource.setAge(age);
    }


    @Override
    public String toString() {
        return "ResourceServerController{" +
                       "testResource=" + testResource +
                       '}';
    }
}
