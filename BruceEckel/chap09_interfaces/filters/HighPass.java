package chap09_interfaces.filters;

//: interfaces/filters/HighPass.java
public class HighPass extends Filter {
    double cutoff;
    public HighPass(double cutoff) { this.cutoff = cutoff; }
    public Waveform process(Waveform input) { return input; }
} ///:~
