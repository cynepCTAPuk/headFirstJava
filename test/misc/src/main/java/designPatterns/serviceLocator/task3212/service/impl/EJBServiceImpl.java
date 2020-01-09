package designPatterns.serviceLocator.task3212.service.impl;

import designPatterns.serviceLocator.task3212.service.Service;

public class EJBServiceImpl implements Service {

    @Override
    public void execute() {
        System.out.println("Executing the EJBService");
    }

    @Override
    public String getName() {
        return "EJBService";
    }

}
