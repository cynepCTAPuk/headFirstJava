package annotation.ru.easyjava;

import java.lang.reflect.Field;

public class GreeterMain {

    @GreeterTarget
    private static Greeter world = new Greeter();

    @GreeterTarget(value = "annotations")
    private static Greeter annotations = new Greeter();

    @GreeterTarget("Java")
    private static Greeter java = new Greeter();

    public static void main(String[] args) throws NoSuchFieldException {

        Field worldField = GreeterMain.class.getDeclaredField("world");
        GreeterTarget worldTarget = worldField.getAnnotation(GreeterTarget.class);
        System.out.println(world.greet(worldTarget.value()));

        Field annotationsField = GreeterMain.class.getDeclaredField("annotations");
        GreeterTarget annotationsTarget = annotationsField.getAnnotation(GreeterTarget.class);
        System.out.println(annotations.greet(annotationsTarget.value()));

        Field javaField = GreeterMain.class.getDeclaredField("java");
        GreeterTarget javaTarget = javaField.getAnnotation(GreeterTarget.class);
        System.out.println(world.greet(javaTarget.value()));
    }
}