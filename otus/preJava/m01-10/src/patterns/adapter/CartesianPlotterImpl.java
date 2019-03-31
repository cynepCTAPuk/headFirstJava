package patterns.adapter;

public class CartesianPlotterImpl implements CartesianPlotter {

    @Override
    public void setPoint(double x, double y) {
        System.out.println("x: " + x + " y: " + y);
    }
}
