package org.example.ioc;

public class ConstructorDI {
    DemoBean demoBean = null;

    public ConstructorDI(DemoBean demoBean) {
        this.demoBean = demoBean;
    }
}
