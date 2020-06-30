import java.awt.*;
import java.lang.String;
import java.util.Scanner;

public class Application{
  public static void main(String[] args){

    System.out.print("Please enter the type of shape:");
    Scanner n = new Scanner(System.in);
    String input="";
    input=n.next();
    Canvas drawing = new Canvas(1080,1080);

    if(input.equals("Circle")){
      drawing.CircleFractal(450,450,128,Color.RED,drawing,0);
    }else if(input.equals("Rectangle")){
      drawing.RectangleFractal(400,400,128,128,Color.RED,drawing,0);
    }else if(input.equals("Triangle")){
      drawing.TriangleFractal(400,400,200,200,Color.RED,drawing,0);
    }
  }


}
