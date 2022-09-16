package shortPuzzles;

public class CodeChallenge34 implements Sampler {
    static void greet() {
        System.out.println("Hello ");
    }

    public static void main(String[] args) {
        Sampler trial = new CodeChallenge34();
//        trial.greet() is impossible to call static method from object
        Sampler.greet();
        CodeChallenge34.greet();
    }
}

interface Sampler {
    static void greet() {
        System.out.println("Good day");
    }
}



