import java.awt.*;

public class application {
    public static void main(String[] args){
        Circle[] a = new Circle[2];
        a[1]= new Ball(1,2,3, Color.BLACK);
        System.out.println(a[1].getColor());
    }
}
