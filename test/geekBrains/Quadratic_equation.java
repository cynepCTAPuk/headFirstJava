class Quadratic_equation {
    static double[] solution(double a, double b, double c) {
        // ax^2+bx+c=0
        // x = (-b +- sqrt(b^2-4ac))/2ac
        var d = b * b - 4 * a * c;
        double[] solution;
        solution = null;
        if (d > 0) {
            solution = new double[2];
            solution[1] = (-b - Math.sqrt(d)) / (2 * a);
            solution[0] = (-b + Math.sqrt(d)) / (2 * a);
        }
        if (d == 0) {
            solution = new double[1];
            solution[0] = -b / (2 * a);
        }
        if (d < 0) {
            solution = new double[0];
            System.out.println("no roots");
        }
        return solution;
    }
}
