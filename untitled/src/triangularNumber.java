public class triangularNumber {

    public int triangularNumber1(int n){
        int sum=0;
        if(n>0){
            sum=n+triangularNumber1(n-1);
        }
        return sum;
    }

}
