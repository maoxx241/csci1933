/*This class is for drawing the canvas and balls */
/*Name:Qi Mao(Student ID:5306940) and Haowen Luo(Student ID:5281069)
username: maoxx241 and luoxx560
Course:CSCI 1933*/
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class BallScreenSaver extends AnimationFrame {
    private double ballX, ballY;
    private int ballSize = 20, number = 1;
    private final int START_SPEED = 300;
    public final int BORDER = 40;
    public Ball[] array = new Ball[1];

    /* These are data members for managing the collision logging, which
       you should also use in your class. */
    private CollisionLogger collisionLogger;
    private static final int COLLISION_BUCKET_WIDTH = 20;
    private int saveCounter = 0;

    public BallScreenSaver() {
        super();

        for (int i = 0; i < number; i++) {
            double dir = randdouble(0, Math.PI * 2);
            array[i].setPos(randdouble(10, getWidth()), randdouble(10, getHeight() ));
            array[i].setSpeedX(Math.cos(dir) * START_SPEED);
            array[i].setSpeedY(Math.sin(dir) * START_SPEED);
        }
        setFPS(30000);
        collisionLogger = new CollisionLogger(this.getWidth(), this.getHeight(), COLLISION_BUCKET_WIDTH);
    }


    public void change(double x, double y, int i){
        /* This method is for change the initial position of new ball when there is a position conflict between new ball and another ball we set before. */
        for(int j=0;j<i;j++){
            if((x-array[j].getXPos())*(x-array[j].getXPos())+(y-array[j].getYPos())*(y-array[j].getYPos())<400){
                ballX=randdouble(BORDER*2, getWidth()-BORDER*2);
                ballY=randdouble(BORDER*2, getHeight()-BORDER*2);
                 Ball ball2 = new Ball(ballX, ballY, 10, Color.red);

                array[i] = ball2;
                change(ballX,ballY,i);
            }
        }
    }

    public BallScreenSaver(int w, int h, String name, int n) {
        /*This method is for setting the position of new ball in the frame we set and giving the initial velocity to the new ball */
        super(w, h, name);
        number = n;
        array = new Ball[n];

        Ball ball1 = new Ball(randdouble(BORDER*2, getWidth()-BORDER*2), randdouble(BORDER*2, getHeight() -BORDER*2), 10, Color.green);
        array[0] = ball1;
        for (int i = 1; i < number; i++) {
            double dir = randdouble(0, Math.PI * 2);
            ballX=randdouble(BORDER*2, getWidth()-BORDER*2);
            ballY=randdouble(BORDER*2, getHeight()-BORDER*2);
            Ball ball = new Ball(ballX, ballY, 10, Color.red);
            ball.setSpeedX(Math.cos(dir) * START_SPEED);
            ball.setSpeedY(Math.sin(dir) * START_SPEED);
            array[i] = ball;
            change(ballX,ballY,i);


        }

        setFPS(8000);
        collisionLogger = new CollisionLogger(this.getWidth(), this.getHeight(), COLLISION_BUCKET_WIDTH);
    }

    public static void main(String[] args) {
        BallScreenSaver bb = new BallScreenSaver(1000, 1000, "Bouncing Ball", 100);
        bb.start();
    }

    public void action() {
        //This method is called once every frame to update the state of the BouncingBall.
        //Part A: the collision between the ball and border.
        for (int i = 0; i < number; i++) {

            array[i].setPos(array[i].getXPos() + array[i].getSpeedX() / getFPS(), array[i].getYPos() + array[i].getSpeedY() / getFPS());



            if (array[i].getXPos() < BORDER || array[i].getXPos() + ballSize > getHeight()-BORDER ) {
                double x = array[i].getSpeedX();
                x *= -1;
                array[i].setSpeedX(x);
            }
            if (array[i].getYPos() < BORDER || array[i].getYPos() + ballSize > getWidth()-BORDER ) {
                double y = array[i].getSpeedY();
                y *= -1;
                array[i].setSpeedY(y);
            }
         //Part B: the collision between new ball and another ball we set before.
            for (int j = 0; j < number; j++) {
                if (j != i) {
                    if (array[i].intersect(array[j])) {
                        collisionLogger.collide(array[i], array[j]);
                        array[i].collide(array[j]);
                        if (array[i].getColor() == Color.green || array[j].getColor() == Color.green) {
                            if (array[i].getColor() == Color.green) {
                                array[j].setColor(Color.green);


                            } else if (array[j].getColor() == Color.green) {
                                array[i].setColor(Color.green);

                            }
                        }

                    }
                }
            }


        }


    }

    public void draw(Graphics g) {
    //This is for drawing the graphic.

        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.white);


        g.drawRect(BORDER,BORDER,getWidth()-BORDER*2,getHeight()-BORDER*2);
     //This part is for set color.
        for (int i = 0; i < number; i++) {
            Color color;
            color=array[i].getColor();
            g.setColor(color);

            g.fillOval((int) array[i].getXPos(), (int) array[i].getYPos(), ballSize, ballSize);

        }






    }

    public int randInt(int min, int max) {
        //a utility method to get a random int between min and max.
        return (int) (Math.random() * (max - min) + min);
    }

    public double randdouble(double min, double max) {
        //a utility method to get a random double between min and max.
        return (Math.random() * (max - min) + min);
    }


    protected void processKeyEvent(KeyEvent e) {
        int keyCode = e.getKeyCode();


        if (e.getID() == KeyEvent.KEY_PRESSED && keyCode == KeyEvent.VK_P) {
            EasyBufferedImage image = EasyBufferedImage.createImage(collisionLogger.getNormalizedHeatMap());
            try {
                image.save("heatmap" + saveCounter + ".png", EasyBufferedImage.PNG);
                saveCounter++;
            } catch (IOException exc) {
                exc.printStackTrace();
                System.exit(1);
            }

        }

        if(e.getID() == KeyEvent.KEY_PRESSED &&keyCode== KeyEvent.VK_RIGHT){
            for(int i=0;i<number;i++){
                array[i].setSpeedX(array[i].getSpeedX()*1.1);
                array[i].setSpeedY(array[i].getSpeedY()*1.1);
            }
        }
        if(e.getID() == KeyEvent.KEY_PRESSED &&keyCode== KeyEvent.VK_LEFT){
            for(int i=0;i<number;i++){
                array[i].setSpeedX(array[i].getSpeedX()*0.9);
                array[i].setSpeedY(array[i].getSpeedY()*0.9);
            }
        }
    }

}
