/*
 * Modified from Frank M. Carrano's
 * Data Structures and Abstractions with Java (3rd Edition)
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class AList<T extends Comparable> {

    private T[] list;
    private int numberOfEntries;

    public AList() {
        list = (T[]) new Comparable[25];
        numberOfEntries = 0;
    }

    public AList(int initialCapacity) {
        numberOfEntries = 0;
        T[] tempList = (T[]) new Comparable[initialCapacity];
        list = tempList;
    }

    public void add(T newEntry) {
        ensureCapacity();
        list[numberOfEntries] = newEntry;
        numberOfEntries++;
    }

    public void add(T[] addList) {
        if (addList.length == 0)
            return;
        for (int i = 0; i < addList.length; i++) {
            add(addList[i]);
        }
    }

    public boolean add(int newPosition, T newEntry) {
        if (newPosition > numberOfEntries || newPosition < 0)
            return false;
        ensureCapacity();
        for (int i = numberOfEntries - 1; i > newPosition; i--) {
            list[i] = list[i - 1];
        }
        list[newPosition] = newEntry;
        numberOfEntries++;
        return true;
    }

    public T remove(int givenPosition) {
        if (givenPosition >= numberOfEntries || givenPosition < 0)
            return null;
        T toReturn = list[givenPosition];
        for (int i = givenPosition; i < numberOfEntries - 1; i++) {
            list[i] = list[i + 1];
        }
        list[numberOfEntries] = null;
        numberOfEntries--;
        return toReturn;
    }

    public T get(int item) {
        if (item >= numberOfEntries || item < 0)
            return null;
        return list[item];
    }

    public int getLength() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    public T[] toArray() {
        T[] result = (T[]) new Comparable[numberOfEntries];
        for (int index = 0; index < numberOfEntries; index++) {
            result[index] = list[index];
        }

        return result;
    }

    private void ensureCapacity() {
        if (numberOfEntries == list.length) {
            list = Arrays.copyOf(list, 2 * list.length);
        }
    }

    public boolean contains(T element) {
        for (int i = 0; i < numberOfEntries; i++) {
            if (list[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String toReturn = "[";
        for (int i = 0; i < numberOfEntries - 1; i++) {
            toReturn += list[i].toString() + ", ";
        }
        toReturn += list[numberOfEntries - 1].toString() + "]";

        return toReturn;
    }



    public AList<T> slice(int start, int stop) {
        if (start < 0) {
            start = 0;
        }
        if (stop > list.length) {
            stop = list.length;
        }

        int num = stop - start;
        T[] newlist = (T[]) new Comparable[num];
        for (int i = 0; i < num; i++) {
            newlist[i] = list[start + i];

        }
        AList<T> nlist = new AList<>(num);
        nlist.add(newlist);
        return nlist;

    }

    public AList<T> slice(int start, int stop, int step) {
        if (start < 0) {
            start = 0;
        }
        if (stop > list.length) {
            stop = list.length;
        }
        int num = stop - start;
        int num2 = num / step;
        T[] newlist = (T[]) new Comparable[num2];
        int j = 0;
        for (int i = 0; i < num; i++) {
            if (i % step == 0) {
                newlist[j] = list[start + i];
                j++;
            }

        }
        AList<T> nlist = new AList<>(num);
        nlist.add(newlist);
        return nlist;

    }

    public void sort(boolean ascending) {

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < i - 1; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    T temp = list[j + 1];
                    list[j + 1] = list[j];
                    list[j] = temp;
                }
            }


        }
        if (ascending) {
            return;
        } else {
            for (int i = 0; i < list.length / 2; i++) {
                T temp = list[i];
                list[i] = list[list.length - 1 - i];
                list[list.length - 1 - i] = temp;
            }
        }
    }

    public static AList<String> fileToAList(File input){
        Scanner fileInput = null;
        String[] array= new String[1];
        try {
            fileInput = new Scanner(input);
            while (fileInput.hasNext()) {

                if(array[array.length-1]!=null){
                    String[] temp=new String[1+array.length];
                    int ind;
                    for(ind=0;ind<array.length;ind++){
                        temp[ind]=array[ind];
                    }
                    array=temp;
                }
                array[array.length-1]= fileInput.nextLine();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        int[] num=new int[array.length];
        String[] str= new String[array.length];
        for(int i=0;i<array.length;i++){
            String[] parts = array[i].split(", ");
            num[i]=Integer.parseInt(parts[0]);
            str[i]=parts[1];

        }

        for(int i = num.length; i > 0; i--){
            for(int j = 0; j < i-1; j++){
                if(num[j]>num[j+1]){
                    int temp = num[j+1];
                    num[j+1] = num[j];
                    num[j] = temp;

                    String temp1 = str[j+1];
                    str[j+1] = str[j];
                    str[j] = temp1;
                }
            }
        }

        AList<String> list=new AList<String>(str.length);
        for(int i=0;i<str.length;i++){
            list.add(str[i]);
        }
        return list;






    }




}
