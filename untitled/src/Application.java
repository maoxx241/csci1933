import java.util.Arrays;
import java.util.stream.IntStream;

public class Application {
    public static void  main(String[] args){
   //     Vehicle[] vehicleArr=new Vehicle[3];
    //    vehicleArr[0]=new Vehicle("hehehehehehe");
    //   vehicleArr[1]=new Vehicle("vovovovovovovo");
     //   vehicleArr[2]=new Bus("adadasdsdad","msmsmsmsmssm",50);
     //   for(int i=0; i<vehicleArr.length;i++){
    //        System.out.println(vehicleArr[i].getStatus());


     //   }
   //     Vehicle cityBus = new Bus("Volvo 7700 Hybrid","Mpls-metro 16",50);
   //     cityBus.setSpeed(40);
       // cityBus.updateFuelLevel(2);
   //     System.out.println(cityBus.getFuelLevel());

      //  triangularNumber a=new triangularNumber();
       // System.out.println(a.triangularNumber(5));
     //   System.out.println(a.triangularNumber1(4));

        //[3,35,6,1,34,62,352,53246,2,1321];
        int[] array=new int[6];
        int[] array1=new int[0];
        array[0]=354;
        array[1]=323;
        array[2]=35123312;
       array[3]=362434;
       array[4]=3423423;
        array[5]=3;
        hhh h=new hhh(array);

        array=h.remove(array,2);
        h.sort(array1);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
        System.out.println();

     //   int[] arrays = new int[]{1,52,5234,6234,21312,2,51,1234,13,52342,3242};
      //  int positon = Arrays.binarySearch(arrays,52);
    //    System.out.println("position is:"+positon);
     //   System.out.println(arrays[positon]);
//




    }
}
