import java.io.File;
public class Application {
    public static void main(String[] args) {
        AList<String> str=new AList<String>(8);
        str.add("a");
        str.add("b");
        str.add("c");
        str.add("d");
        str.add("e");
        str.add("f");
        str.add("g");
        str.add("h");
        System.out.println(str.slice(-1,2000, 2));
        System.out.println(str.slice(1,7,2));
        AList<Integer> i=new AList<Integer>(9);
        i.add(1);
        i.add(2);
        i.add(3);
        i.add(4);
        i.add(5);
        i.add(6);
        i.add(7);
        i.add(8);
        i.add(9);
        i.sort(true);
        System.out.println(i);
        i.sort(false);
        System.out.println(i);

        System.out.println(str.fileToAList(new File("/Users/kindred/Documents/csci1933/labs/lab8/src/input.txt")));


    }
    }