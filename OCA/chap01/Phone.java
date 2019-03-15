/*
The declaration of a class is composed of the following parts:
■ Access modifiers
■ Nonaccess modifiers
 abstract static final synchronized native strictfp transient volatile
■ Class name
■ Name of the base class, if the class is extending another class
■ All implemented interfaces, if the class is implementing any interfaces
■ Class body (class fields, methods, constructors), included within a pair of curly braces, {}
 */
package chap01;

class Phone {
    String model;
    String company;

    Phone(String model) {
        this.model = model;
    }

    double weight;

    void makeCall(String number) {
    // code
    }

    void receiveCall() {
    // code
    }
}