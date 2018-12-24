package chap01;

public class Light {
    private boolean status;
    private int brightness;

    public Light() {
        brightness = 0;
        status = false;
    }

    public void on() {
        brightness = 50;
        status = true;
    }

    public void of() {
        brightness = 0;
        status = false;
    }

    public int brighten() {
        if (status && brightness < 100) brightness++;
        return brightness;
    }

    public int dim() {
        if (status && brightness > 0) brightness--;
        if (brightness == 0) of();
        return brightness;
    }

    @Override
    public String toString() {
        return String.format("Light{ status= %5s, " +
                "brightness=%3d}", status, brightness);
    }
}
