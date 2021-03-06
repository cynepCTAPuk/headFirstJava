package chap10_innerclasses.controller;

//: innerclasses/controller/Event.java
// The common methods for any control event.
// Общие для всякого управляющего события методы
public abstract class Event {
    private long eventTime;
    protected final long delayTime;
    public Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }
    // Allows restarting. С возможностью перезапуска.
    public void start() { eventTime = System.nanoTime() + delayTime; }
    public boolean ready() { return System.nanoTime() >= eventTime; }
    public abstract void action();
} ///:~