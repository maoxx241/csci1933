/*Name:Qi Mao(Student ID:5306940) and Haowen Luo(Student ID:5281069)
username: maoxx241 and luoxx560
Course:CSCI 1933
Canvas,Circle,Triangle,Rectangle part made by Qi Mao
Application part made by Haowen Luo*/

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        //choose the shape
        System.out.print("Please enter the type of shape(Circle, Rectangle, Triangle):");
        Scanner n = new Scanner(System.in);
        String input = n.next();

        for (int i = 0; i < 2; i++) {
            //output Circle Fractal and the area
            if (input.equals("Circle")) {
                Canvas drawing = new Canvas(1080, 1080);
                System.out.print("totalArea:" + drawing.CircleFractal(300, 300, 100, drawing, 0) + ";");
                break;

                //output Rectangle Fractal and the area
            } else if (input.equals("Rectangle")) {
                Canvas drawing = new Canvas(1080, 1080);
                System.out.print("totalArea:" + drawing.RectangleFractal(600, 600, 100, 100, drawing, 0) + ";");
                break;

                //output Triangle Fractal and the area
            } else if (input.equals("Triangle")) {
                Canvas drawing = new Canvas(1080, 1080);

                System.out.print("totalArea:" + drawing.TriangleFractal(400, 400, 190, 190, drawing, 0) + ";");
                break;

                //choose the shape again
            } else if (input != "Circle" || input != "Triangle" || input != "Rectangle") {
                System.out.print("You enter a wrong shape, Please enter again:");
                input = n.next();
            }
        }
    }
}
