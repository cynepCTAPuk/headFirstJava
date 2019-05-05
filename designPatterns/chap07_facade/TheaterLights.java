package chap07_facade;

public class TheaterLights {
    boolean theaterLightsPower;
    int theaterLightsLevel;

    public void on() {
        theaterLightsPower = true;
        System.out.println("Theater Ceiling Lights is on");
    }
    public void off() {
        System.out.println("Theater Ceiling Lights is off");
    }
    public void dim(int lightsLevel) {
        this.theaterLightsLevel = lightsLevel;
        System.out.println("Theater Ceiling Lights dimming to " + theaterLightsLevel + "%");
    }

}
