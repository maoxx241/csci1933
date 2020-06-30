/*Name:Qi Mao(Student ID:5306940) and Haowen Luo(Student ID:5281069)
username: maoxx241 and luoxx560
Course:CSCI 1933*/
public class CollisionLogger {
    private int width, height, b1;
    private int[][] arr = new int[0][0];
    private int x, y;
    private double pointx,pointy;
    /* add data members here */

    public CollisionLogger(int screenWidth, int screenHeight, int bucketWidth) {
        /* constructor code here */
        //This method is for separating the canvas to bucket and setting the size of bucket..
        b1 = bucketWidth;
        width = screenWidth / bucketWidth;
        height = screenHeight / bucketWidth;
        arr = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                arr[i][j] = 0;

            }
        }

    }


    /**
     * This method records the collision event between two balls. Specifically, in increments the bucket corresponding to
     * their x and y positions to reflect that a collision occurred in that bucket.
     */
    public void collide(Ball one, Ball two) {
    	/* update data members to reflect the collision event between ball "one" and ball "two" */
    	double a=two.getXPos()-one.getXPos();
    	double b=two.getSpeedX()-one.getSpeedX();
    	double c=two.getYPos()-one.getYPos();
    	double d=two.getSpeedY()-one.getSpeedY();
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


        pointx=one.getXPos()+one.getSpeedX()*t;
        pointy=one.getYPos()+one.getSpeedY()*t;

        x = (int)  pointx/ b1;
        y = (int) pointy / b1;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (x == i && y == j) {
                    arr[x][y] = arr[x][y] + 1;
                }

            }
        }

    }

    /**
     * Returns the heat map scaled such that the bucket with the largest number of collisions has value 255,
     * and buckets without any collisions have value 0.
     */
    public int[][] getNormalizedHeatMap() {


        //This part is for recording the largest value we have.
        int temp = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (arr[i][j] > temp) {
                    temp = arr[i][j];
                }

            }
        }
        //this part is for setting the largest value to 255.
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (arr[i][j] == temp) {
                    arr[i][j] = 255;
                }

            }
        }
        return arr;
    }
}
