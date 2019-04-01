package com.javacode.lambdas;

public class LambdaExample {
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

        LambdaScopeTest scope = new LambdaScopeTest();
        LambdaScopeTest.LambdaScopeInner inner = scope.new LambdaScopeInner();
        inner.testScope(9999.000);
    }

}
