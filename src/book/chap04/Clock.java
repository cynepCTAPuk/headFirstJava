/*
 * Copyright (c) 2018/7/1 11:39
 * CTAPuk
 */

package book.chap04;

class Clock {
    String time;
    void setTime(String t) {
        time = t;

    }
    String getTime() {
        return time;
    }

    public static void main(String[] args) {
        Clock c = new Clock();
        c.setTime("12:45");
        String tod = c.getTime();
        System.out.println("time: " + tod);
    }
}
