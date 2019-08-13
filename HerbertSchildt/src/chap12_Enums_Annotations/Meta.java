package chap12_Enums_Annotations;

class Meta {
    // Annotate a method
    @MyAnno(str = "Annotation Example", val = 100)
    public static void myMethod() {
        Meta meta = new Meta();
        // Obtain the annotation for this method and display the values of the members
        try {
            // First, get a Class object that represents this class
//            Class<?> obClass = meta.getClass();
            // Now, get a Method object that represents this method
//            Method method = obClass.getMethod("myMethod");
            // Next, get the annotation for this class
//            MyAnno annotation = method.getAnnotation(MyAnno.class);
            MyAnno annotation = meta
                    .getClass()
                    .getMethod("myMethod")
                    .getAnnotation(MyAnno.class);

            // Finally, display the values
            System.out.println(annotation.str() + " " + annotation.val());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        myMethod();
    }
}
