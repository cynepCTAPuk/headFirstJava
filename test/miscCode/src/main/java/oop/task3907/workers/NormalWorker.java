package oop.task3907.workers;

public class NormalWorker implements Worker, Eater, Sleeper {
    @Override
    public void work() {
        System.out.println("NormalWorker is working!");
    }

    @Override
    public void eat() {
        System.out.println("NormalWorker is eating!");
    }

    @Override
    public void sleep() {
        System.out.println("NormalWorker is sleeping!");
    }
}