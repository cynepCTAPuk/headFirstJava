package ru.otus.l141;

class ThreadInfo {

    void print() {
        Thread mainThread = Thread.currentThread(); //get an object ot the main thread
        System.out.println("Thread name: " + mainThread.getName());
        mainThread.setName("MyMain"); //set name to the thread
        System.out.println("New name: " + mainThread.getName());
        //get priority of the main thread
        System.out.println("Thread priority: " + mainThread.getPriority() + "\n");

        //create new thread with runnable lambda
        Thread thread2 = new Thread(() ->
        {
            try {
                Thread.sleep(10);
                System.out.println("Hello from the thread: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //set daemon
        thread2.setDaemon(true);
        thread2.start();
        thread2.setPriority(10);
        System.out.println(thread2.getName() + " Thread priority: " + thread2.getPriority());

        //join to a the main thread
        //thread2.join();

        //get thread state
        System.out.println("Main thread state: " + mainThread.getState());
        System.out.println("thread2 state: " + thread2.getState());
    }
}
