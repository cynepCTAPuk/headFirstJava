package chap01;

public class Light {
    private boolean status = false;
    private int bright = 0;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getBright() {
        return bright;
    }

    public void setBright(int bright) {
        this.bright = bright;
    }

    public void on() {
        status = true;
    }

    public void of() {
        status = false;
    }

    public void brghten() {
        if (bright < 100) {
            bright++;
            status = true;
        }
    }

    public void dim() {
        if (bright > 0) bright--;
        if (bright == 0) status = false;
    }
}
