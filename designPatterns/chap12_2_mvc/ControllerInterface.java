package chap12_2_mvc;

public interface ControllerInterface {
    void start();

    void stop();

    void increaseBPM();

    void decreaseBPM();

    void setBPM(int bpm);
}