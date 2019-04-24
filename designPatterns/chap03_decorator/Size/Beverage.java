package chap03_decorator.Size;

public abstract class Beverage {
    public enum Size {TALL, CRANDE, VENTI};
    Size size = Size.TALL;
    String description = "Unknown Beverage";
    public String getDescription() {
        return description;
    }
    public Size getSize() {
        return size;
    }
    public void setSize(Size size) {
        this.size = size;
    }
    public abstract double cost();
}