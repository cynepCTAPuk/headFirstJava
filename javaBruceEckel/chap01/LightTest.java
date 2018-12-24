package chap01;

public class LightTest {
    public static void main(String[] args) {
        Light light = new Light();
        light.on();
        System.out.println(light);
        light.brighten();
        System.out.println(light);
        for (int i = 0; i < 51; i++) light.dim();
        System.out.println(light);
        light.of();
        System.out.println(light);
    }

}
