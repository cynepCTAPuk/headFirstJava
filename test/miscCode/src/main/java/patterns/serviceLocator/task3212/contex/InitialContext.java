package patterns.serviceLocator.task3212.contex;

import patterns.serviceLocator.task3212.service.impl.EJBServiceImpl;
import patterns.serviceLocator.task3212.service.impl.JMSServiceImpl;

public class InitialContext {
    public Object lookup(String jndiName) {

        if (jndiName.equalsIgnoreCase("EJBService")) {
            System.out.println("Looking up and creating a new EJBService object");
            return new EJBServiceImpl();
        } else if (jndiName.equalsIgnoreCase("JMSService")) {
            System.out.println("Looking up and creating a new JMSService object");
            return new JMSServiceImpl();
        }
        return null;
    }
}
