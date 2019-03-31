package patterns.adapter;

public class Polar2CartesianAdapter implements PolarPlotter {
    private final CartesianPlotter cartesian;

    public Polar2CartesianAdapter(CartesianPlotter cartesian) {
        this.cartesian = cartesian;
    }

    public void setPoint(double r, double theta) {
        cartesian.setPoint(r * Math.cos(theta), r * Math.sin(theta));
    }
}
