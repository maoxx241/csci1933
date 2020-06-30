import java.awt.*;

public class Circle {

    private double x_position = 0.0;
    private double y_position = 0.0;
    private double radius = 0.0;
    private Color color = Color.BLACK;

    public Circle(double a, double b, double c) {
        x_position = a;
        y_position = b;
        radius = c;
        color = Color.BLACK;
    }

    public double calculatePerimeter() {
        return radius * 2 * Math.PI;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public void setColor(Color value) {
        color = value;
    }

    public void setPos(double x_value, double y_value) {
        x_position = x_value;
        y_position = y_value;
    }

    public void setRadius(double value) {
        radius = value;
    }

    public Color getColor() {
        return color;
    }

    public double getXPos() {
        return x_position;
    }

    public double getYPos() {
        return y_position;
    }

    public double getRadius() {
        return radius;
    }
}
