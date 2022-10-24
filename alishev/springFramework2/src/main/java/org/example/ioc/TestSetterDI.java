package org.example.ioc;

public class TestSetterDI {
    DemoBean demoBean = null;

    public void setDemoBean(DemoBean demoBean) {
        this.demoBean = demoBean;
    }
}
