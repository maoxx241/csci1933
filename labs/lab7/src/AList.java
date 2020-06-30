/*
 * Modified from Frank M. Carrano's 
 * Data Structures and Abstractions with Java (3rd Edition)
 */
import java.util.Arrays;

public class AList<T>{

    private T[] list;
    private int numberOfEntries;

    public AList(){
        list = (T[]) new Object[25];
        numberOfEntries = 0;
    }

    public AList(int initialCapacity){
        numberOfEntries = 0;
        list= (T[]) new Object[initialCapacity];

    }

    public void add(T newEntry){
        ensureCapacity();
        list[numberOfEntries] = newEntry;
        numberOfEntries++;
    }

    public T get(int item){
        return list[item];
    }

    public int getLength(){
        return numberOfEntries;
    }

    public boolean isEmpty(){
        return numberOfEntries == 0;
    }

    public boolean add(int newPosition, T element){
        ensureCapacity(newPosition);
        int temp=0;
        for(int i=0;i<list.length;i++){
            if(list[i]==null){
                temp=i;
                break;
            }

        }
        if(list[newPosition]==null&&newPosition==temp) {
            list[newPosition] = element;
            return true;
        }else{
            return false;
        }

    }

    public T remove(int givenPosition){
        if(givenPosition<list.length){
            list[givenPosition]=null;
        }
        for(int i=givenPosition;i<list.length-1;i++){
            list[i]=list[i+1];
        }
        return list[givenPosition];

    }

    public T[] toArray(){
        T[] result =(T[]) new Object[numberOfEntries];
        for(int index = 0; index < numberOfEntries; index++){
          result[index] = list[index];
        }

        return result;
    }

    private void ensureCapacity(){
        if (numberOfEntries == list.length){
            list = Arrays.copyOf(list, 2 * list.length);
        }
    }
    private void ensureCapacity(int position){
        if (position == list.length){
            list = Arrays.copyOf(list, 2 * list.length);
        }
    }
    public boolean contains(T element){
        boolean result=false;
        int temp=0;
        for(int i=0;i<list.length;i++){
            if(list[i]==null){
                temp=i;
                break;
            }

        }
        for(int i=0;i<temp;i++){
            if(list[i].equals(element)){
                result=true;
            }
        }
        return result;
    }


    public void add(T[] list){
        int len1=this.list.length;
        int len2=list.length;
        this.list=Arrays.copyOf(this.list, len1+len2);
        int temp=0;
        for(int i=len1;i<this.list.length;i++){
            this.list[i]=list[temp];
            temp++;
        }



    }
    public String toString(){

        String a="[";
        for(int i =0;i<getLength();i++){
            if(i != getLength()-1) {
                a = a + this.list[i] + ", ";
            }
            else{
                a = a + this.list[i];
            }
        }
        a=a+"]";
        return a;
    }
}
