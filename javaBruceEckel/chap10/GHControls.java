package chap10;

import chap10.controller.*;

public class GHControls extends GreenhouseControls {
    private boolean wet = false;
    public class WetOn extends Event {
        public WetOn(long delayTime) { super(delayTime); }
        public void action() {
            // Put hardware control code here to physically turn on the wet.
            wet = true;
        }
        public String toString() { return "Wet is on"; }
    }
    public class WetOff extends Event {
        public WetOff(long delayTime) { super(delayTime); }
        public void action() {
            // Put hardware control code here to physically turn off the wet.
            wet = false;
        }
        public String toString() { return "Wet is off"; }
    }

}
