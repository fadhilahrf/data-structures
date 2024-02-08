package org.main;

import java.util.Objects;

public class Set <T> {

    private T[] arr =(T[]) new Object[10];

    private int size = 0;

    public Set(T[] array) {
        for(T value: array) {
            add(value);
        }
    }

    public Set() {}

    public void add(T value) {
        if(!contains(value)) {
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
    }

    public boolean contains(T value) {
        for(int i=0;i<size;i++) {
            if(Objects.equals(value, arr[i])) {
                return true;
            }
        }
        return false;
    }

    public void remove(T value) {
        if(contains(value)){
            int index = 0;
            for(int i=0;i<size;i++) {
                if(Objects.equals(value, arr[i])) {
                    index = i;
                }
            }

            for(int i=index;i<size;i++) {
                arr[i] = arr[i+1];
            }

            size--;
        }

    }

    public int size() {
        return size;
    }

    public T[] toArray() {
        T[] array = (T[]) new Object[size];
        for(int i=0;i<size;i++) {
            array[i] = this.arr[i];
        }

        return array;
    }


}
