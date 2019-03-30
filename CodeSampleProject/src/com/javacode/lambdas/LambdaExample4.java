package com.javacode.lambdas;

public class LambdaExample4 {
    public static void main(String[] args) {
        String s = "Hello";
        String suffix = "Alex";
        Double d = 0.123;
        /*
        CustomClass::staticMethod
        customClassInstance::nonStaticMethod
        CustomClass::nonStaticMethod
        CustomClass::new
         */
        TransformUtils<Double> doubleUtils = new TransformUtils<>();
        System.out.println(doubleUtils.transform(d, Math::sin));

        TransformUtils<String> stringUtils = new TransformUtils<>();
        System.out.println(stringUtils.transform(s, TransformUtils::exclaim));

        System.out.println(stringUtils.transform(s, x -> x.concat(suffix)));
        System.out.println(stringUtils.transform(suffix, s::concat));

        System.out.println(stringUtils.transform(s, String::toUpperCase));
        System.out.println(stringUtils.transform(s, y -> y.toUpperCase()));

        System.out.println(stringUtils.transform(s, String::new));
    }
}
