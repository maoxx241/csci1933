public class hhh {
    private int[] num;
    public hhh(int[] num){
        this.num=num;
    }

    public int[] sort(int[] array){
        for(int i = array.length; i > 0; i--){
            for(int j = 0; j < i-1; j++){
                if(array[j]>array[j+1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public int[] remove(int[] array, int i){
        for(;i<array.length-1;i++){
            array[i]=array[i+1];
        }
        int[] temp=new int[array.length-1];
        for(int j=0;j<array.length-1;j++){
            temp[j]=array[j];
        }
        array=temp;
        return array;
    }

    public int[] add(int[] array, int num){
        int[] temp=new int[array.length+1];
        for (int i=0;i<array.length;i++){
            temp[i]=array[i];
        }
        temp[temp.length-1]=num;
        array=temp;
        return array;
    }
}
