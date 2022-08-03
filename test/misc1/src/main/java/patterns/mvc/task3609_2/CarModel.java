package patterns.mvc.task3609_2;

public class CarModel {
    private String brand;
    private String model;
    private int speed;
    private int maxSpeed;

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public int getSpeed() {
        return speed;
    }
    public int getMaxSpeed() {
        return maxSpeed;
    }
}