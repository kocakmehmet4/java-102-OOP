import java.util.ArrayList;
import java.util.List;

public class MyList <T>{
    private int capacity;
    private T [] array;
    private int size;


    MyList(){
        this(10);
    }
    MyList(int capacity){
        this.capacity=capacity;
        this.array=(T[]) new Object[capacity];
        this.size=0;

    }
    public int size(){

    return size;

    }

    public int getCapacity(){

        return capacity;
    }

    public void add(T data){
        if(size==capacity){
            expandArray();
        }
        array[size]=data;
        size++;

    }
    public T get(int index){
        if(index>=0 && index<size){
            return array[index];
        }
        return null;
    }

    public T remove(int index){
        if(index>=0 && index<size){
            array[index]=null;
            for(int i=index;i<size-1;i++){
                array[i]=array[i+1];
            }
            size--;
        }
        return null;
    }
    public T set(int index,T data){
        if(index>=0 && index<size){
            array[index]=data;
        }
        return null;
    }
    public String toString(){
        String sb= new String();
        for (int i = 0; i < size; i++) {
            sb=sb +" "+ array[i];
        }
        return sb;

    }

    private void expandArray(){
        this.capacity*=2;
        T []  newArray=(T[]) new Object[capacity];
        for(int i=0;i<size;i++){
            newArray[i]=array[i];
        }
        array=newArray;

    }

    public MyList<T> subList(int start,int finish){
        MyList<T> myList=new MyList<>();
        for (int i=start;i<finish;i++){
            myList.add(array[i]);
        }
        return myList;
    }

    public void clear(){
        size=0;
        capacity=10;

    }
    public boolean contains(T data){
        for (int i=0;i<size;i++){
            if(data==array[i]){
                return true;
            }
        }
        return false;
    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }


}
