package chap08_polymorphism;

import static util.Print.print;

public class Exercise16 {
    public static void main(String[] args) {
        Starship starship = new Starship();
        starship.showStatus();
        starship.warning();
        starship.showStatus();
        starship.bad();
        starship.showStatus();
        starship.good();
        starship.showStatus();
    }
}
class Starship {
    private Alert alert = new Good();
    void bad() { alert = new Bad(); }
    void good() { alert = new Good(); }
    void warning() { alert = new Warning(); }
    public void showStatus(){ alert.status();}
}
interface Alert { void status(); }
class Good implements Alert {
    @Override public void status() {print("Good");}
}
class Bad implements Alert {
    @Override public void status() {print("Bad");}
}
class Warning implements Alert {
    @Override public void status() {print("Warning");}
}
