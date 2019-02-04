package chap01;

public class Light {
    private boolean status;
    private int brightness;

    Light() {
        brightness = 0;
        status = false;
    }

    void on() {
        brightness = 50;
        status = true;
    }

    void of() {
        brightness = 0;
        status = false;
    }

    void brighten() {
        if (status && brightness < 100) brightness++;
    }

    void dim() {
        if (status && brightness > 0) brightness--;
        if (brightness == 0) of();
    }

    @Override
    public String toString() {
        return String.format("Light{ status= %5s, " +
                "brightness=%3d}", status, brightness);
    }
}
