package create;

public class Creature {
    static int count;
    private String name;

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    Creature() {
        ++count;
//        System.out.println("Created creature " + count);
    }

    @SuppressWarnings("deprecation")
    public Creature reproduce() {
        Class clazz = this.getClass();
        try {
            return (Creature) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
