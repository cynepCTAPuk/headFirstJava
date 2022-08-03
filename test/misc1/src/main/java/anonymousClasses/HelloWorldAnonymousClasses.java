package anonymousClasses;

public class HelloWorldAnonymousClasses {
    interface HelloWorld {
        void greet();

        void greetSomeone(String someone);
    }

    public void sayHello() {
        class EnglishGreeting implements HelloWorld {
            public void greet() {
                greetSomeone("world");
            }

            public void greetSomeone(String someone) {
                System.out.println("Hello " + someone);
            }
        }
        HelloWorld englishGreeting = new EnglishGreeting();
        HelloWorld frenchGreeting = new HelloWorld() {
            public void greet() {
                greetSomeone("tout le monde");
            }

            public void greetSomeone(String someone) {
                System.out.println("Salut " + someone);
            }
        };
        HelloWorld italianGreeting = new HelloWorld() {
            public void greet() {
                greetSomeone("mondo");
            }

            public void greetSomeone(String someone) {
                System.out.println("Ciao, " + someone);
            }
        };
        HelloWorld spanishGreeting = new HelloWorld() {
            public void greet() {
                greetSomeone("mundo");
            }

            public void greetSomeone(String someone) {
                System.out.println("Hola, " + someone);
            }
        };

        englishGreeting.greet();
        frenchGreeting.greet();
        italianGreeting.greet();
        spanishGreeting.greet();
        frenchGreeting.greetSomeone("Fred");
    }

    public static void main(String... args) {
        HelloWorldAnonymousClasses myApp = new HelloWorldAnonymousClasses();
        myApp.sayHello();
    }
}
