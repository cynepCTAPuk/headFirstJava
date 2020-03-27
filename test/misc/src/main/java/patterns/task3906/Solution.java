package patterns.task3906;

/* 
Интерфейсы нас спасут!
*/
public class Solution {
    public static void main(String[] args) {
        Switchable switchable = new LightBulb();
        ElectricPowerSwitch electricPowerSwitch = new ElectricPowerSwitch(switchable);

        electricPowerSwitch.press();
        electricPowerSwitch.press();
    }
}
