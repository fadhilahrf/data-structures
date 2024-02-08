package org.main;

public class ArrayList <T> {

    private T[] arr =(T[]) new Object[10];

    private int size = 0;

    public ArrayList(T[] array) {
        for(T value: array) {
            add(value);
        }
    }

    public ArrayList() {}

    public void add(T value) {
        if(size>=arr.length){
            T[] tempArr = (T[]) new Object[size+10];
            for(int i=0;i<arr.length;i++){
                tempArr[i] = arr[i];
            }
            tempArr[arr.length] = value;
            arr = tempArr;
        }else{
            arr[size] = value;
        }
        size++;
    }

    public void remove(int index) {
        try {
            if(index>=size) {
                throw new Exception("Index out of bounds");
            }
        }catch (Exception e) {

        }

        for(int i=index;i<size;i++){
            arr[i] = arr[i+1];
        }
        size--;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        try {
            if(index>=size) {
                throw new Exception("Index out of bounds");
            }
        }catch (Exception e) {

        }

        return arr[index];
    }

    public void set(int index, T value) {
        try {
            if(index>=size) {
                throw new Exception("Index out of bounds");
            }
        }catch (Exception e) {

        }
        arr[index] = value;
    }

    public T[] toArray() {
        T[] array = (T[]) new Object[size];
        for(int i=0;i<size;i++) {
            array[i] = this.arr[i];
        }

        return array;
    }
}
