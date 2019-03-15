package create;

public class Creature {
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
