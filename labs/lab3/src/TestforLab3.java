public class TestforLab3 {
    public static void main(String[] args){
        lab3 a = new lab3();
        System.out.println(a.reverseVowels("hello"));
        System.out.println(a.reverseVowels("hello world"));
        System.out.println(a.reverseVowels("gophers"));
        System.out.println(a.fibonacciReverse(3));
        System.out.println(a.fibonacciReverse(5));
        System.out.println(a.fibonacciReverse(10));
        System.out.println(a.recursiveReverse(56));
        System.out.println(a.recursiveReverse(19924));
        System.out.println(a.recursiveReverse(9876543));


        int[] arr=new int[4];
        arr[0]=0;
        arr[1]=1;
        arr[2]=2;
        arr[3]=3;
        System.out.println(arr[-2]);

    }
}
