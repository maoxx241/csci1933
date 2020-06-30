

import java.awt.*;
import java.util.Arrays;

public class Application {
    public static void main(String[] args){
        AList<Ball> l1= new AList<Ball>();
        AList<Circle> l2=new AList<Circle>(20);
        l1.add(new Ball(1,2,3, Color.BLACK));
        l1.get(1);
        System.out.println(l1.getLength());
        System.out.println(l2.isEmpty());
        l2.add(new Ball(1,2,3, Color.BLACK));


        System.out.println(l1.add(0,new Ball(2,2,3,Color.BLUE)));
        System.out.println(l1.add(1,new Ball(2,2,3,Color.BLUE)));
        System.out.println(l1.add(3,new Ball(2,2,3,Color.BLUE)));
        System.out.println(l1.remove(0));
        System.out.println(l1.remove(1));

        System.out.println(l1.contains(new Ball(2,2,3,Color.BLUE)));
        System.out.println(l1.contains(new Ball(2,2,3,Color.BLUE)));
        System.out.println(Arrays.toString(l1.toArray()));

        System.out.println(l1.contains(new Ball(2,2,3,Color.BLUE)));
        System.out.println(l1.contains(new Ball(2,2,3,Color.BLUE)));
        System.out.println(l1);
        AList<String> ab =new AList<String>(6);

        
        ab.add("these");
        ab.add("could");
        ab.add("be");
        ab.add("strings");
        System.out.println(Arrays.toString(ab.toArray()));
        System.out.println(ab.toString());






    }

}
