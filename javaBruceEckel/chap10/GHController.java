package chap10;

//: innerclasses/GreenhouseController.java
// Configure and execute the greenhouse system.
// {Args: 5000}
import chap10.controller.*;

public class GHController {
    public static void main(String[] args) {
        GHControls gc = new GHControls();
        // Instead of hard-wiring, you could parse
        // configuration information from a text file here:
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new VentilationOn(100),
                gc.new LightOn(200),
                gc.new WetOn(300),
                gc.new WetOff(400),
                gc.new LightOff(500),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                gc.new VentilitionOff(1300),
                gc.new ThermostatDay(1400)
        };
        gc.addEvent(gc.new Restart(2000, eventList));
        if(args.length == 1) {
            gc.addEvent( new GHControls.Terminate(Integer.valueOf(args[0])));
        }
        gc.run();
    }
} /* Output:
Bing!
Thermostat on night setting
Light is on
Light is off
Greenhouse water is on
Greenhouse water is off
Thermostat on day setting
Restarting system
Terminating
*///:~