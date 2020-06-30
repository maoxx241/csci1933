/*Name:Qi Mao(Student ID:5306940) and Haowen Luo(Student ID:5281069)
username: maoxx241 and luoxx560
Course:CSCI 1933*/
import java.awt.*;
//This class is for set the basic elements of ball include the speed in X axis,the speed in Y axis, the radius,and the color..
public class Ball extends Circle {
    private Color color = Color.BLACK;
    private double speedY = 0.0;
    private double speedX = 0.0;
    public double pointx,pointy,t;

    public Ball(double x_value, double y_value, double radius_value, Color color_value) {
        super(x_value, y_value, radius_value);
        color = color_value;

    }



    public void setSpeedY(double y_speed) {
        speedY = y_speed;

    }

    public void setSpeedX(double x_speed) {
        speedX = x_speed;

    }

    public double getSpeedY() {
        return speedY;

    }

    public double getSpeedX() {
        return speedX;

    }

    public  Color getColor(){
        return color;
    }

    public void setColor(Color color_value){
        color=color_value;
    }

    public void updatePosition(double nuits_passed) {
        double xp=getXPos() + nuits_passed * getSpeedX();
        double yp=getYPos() + nuits_passed * getSpeedY();
        setPos(xp,yp);

    }

    public Boolean intersect(Ball ball) {
        //The method is for detecting if the ball collide something.
        boolean result = ((getXPos() - ball.getXPos()) * (getXPos() - ball.getXPos()) + (getYPos() - ball.getYPos()) * (getYPos() - ball.getYPos())) <= (getRadius() + ball.getRadius()) * (getRadius() + ball.getRadius());
        return result;

    }

    public void point(Ball ball) {
        // This is for finding out the position of collision point.
        double a=ball.getXPos()-getXPos();
        double b=ball.getSpeedX()-getSpeedX();
        double c=ball.getYPos()-getYPos();
        double d=ball.getSpeedY()-getSpeedY();
        double t;
        double t1=(a*b+c*d+Math.sqrt((a*d+b*c)*(a*d+b*c)+(b*b+d*d)*4*100))/(b*b+d*d);
        double t2=(a*b+c*d-Math.sqrt((a*d+b*c)*(a*d+b*c)+(b*b+d*d)*4*100))/(b*b+d*d);
        if (t1 < t2 && t1 > 0) {
            t = t1;
        } else if (t1 < t2 && t1 < 0 && t2 > 0) {
            t = t2;
        } else if (t1 > t2 && t2 > 0) {
            t = t2;
        } else if (t1 > t2 && t2 < 0 && t1 > 0) {
            t = t1;
        } else {
            return;
        }


        pointx=getXPos()+getSpeedX()*t;
        pointy=getYPos()+getSpeedY()*t;
    }


    public void collide(Ball ball){
        //This method is for setting the speed of ball after collision.
        if(intersect(ball)) {
            point(ball);
            //with non-overlap
            if(Math.sqrt(getSpeedX()*getSpeedX()+getSpeedY()*getSpeedY())*Math.sqrt((getXPos()-pointx)*(getXPos()-pointx)+(getYPos()-pointy)*(getYPos()-pointy))==-1&&
                    Math.sqrt(ball.getSpeedX()*ball.getSpeedX()+ball.getSpeedY()*ball.getSpeedY())*Math.sqrt((ball.getXPos()-pointx)*(ball.getXPos()-pointx)+(ball.getYPos()-pointy)*(ball.getYPos()-pointy))==-1){
                return;
            }else{
                //other case
                double xi = getXPos();
                double yi = getYPos();
                double xj = ball.getXPos();
                double yj = ball.getYPos();
                double vix = getSpeedX();
                double viy = getSpeedY();
                double vjx = ball.getSpeedX();
                double vjy = ball.getSpeedY();
                double D = Math.sqrt((xi - xj) * (xi - xj) + (yi - yj) * (yi - yj));
                double deltaX = (xi - xj) / D;
                double deltaY = (yi - yj) / D;
                setSpeedX((vjx * deltaX + vjy * deltaY) * deltaX - (-vix * deltaY + viy * deltaX) * deltaY);
                setSpeedY((vjx * deltaX + vjy * deltaY) * deltaY + (-vix * deltaY + viy * deltaX) * deltaX);
                ball.setSpeedX((vix * deltaX + viy * deltaY) * deltaX - (-vjx * deltaY + vjy * deltaX) * deltaY);
                ball.setSpeedY(((vix * deltaX + viy * deltaY) * deltaY + (-vjx * deltaY + vjy * deltaX) * deltaX));

            }





















        }
    }



}






