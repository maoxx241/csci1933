import java.awt.*;

public class Triangle{


  private double x_position = 0.0;
  private double y_position = 0.0;
  private double width = 0.0;
  private double height = 0.0;
  private Color color = Color.WHITE;

  public Triangle(double a, double b, double c,double d){
    x_position = a;
    y_position = b;
    width = c;
    height = d;
    color = Color.WHITE;
  }

  public double calculatePerimeter(){
    return width + 2 * (Math.sqrt((0.5 * width) * (0.5 * width) + height * height));
  }

  public double calculateArea(){
    return 0.5 * height * width;
  }

  public void setColor(Color value){
    color = value;
  }

  public void setPos(double x_value,double y_value) {
      x_position = x_value;
      y_position = y_value;
  }

  public void setWidth(double value) {
      width = value;
  }

  public void setHeight(double value) {
      height = value;
  }

  public Color getColor(){
    return color;
  }

  public double getXPos() {
      return x_position;
  }

  public double getYPos() {
      return y_position;
  }

  public double getWidth() {
      return width;
  }

  public double getHeight() {
      return height;
  }
}
