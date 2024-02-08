package org.main;

public class Queue <T> {

    private T[] values;

    private int first = -1;

    private int latest = -1;

    private int maxSize = 0;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
    }

    public Queue() {
        this.maxSize = 10;
        values = (T[]) new Object[this.maxSize];
    }

    public void enqueue(T value) {
        try {
            if(isFull()) {
                throw new Exception("Queue is full");
            }
        }catch (Exception e) {

        }

        latest++;
        values[latest] = value;
    }

    public void dequeue() {
        for(int i=0;i<=latest;i++){
            if(i<maxSize-1) {
                values[i] = values[i+1];
            }else {
                values[i] = null;
            }
        }
        latest--;
    }

    public T front() {
        return values[0];
    }

    public T rear() {
        return values[latest];
    }

    public boolean isEmpty() {
        if(latest==-1){
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if(latest==maxSize-1){
            return true;
        }
        return false;
    }

    public T[] toArray() {
        T[] tempValues = (T[]) new Object[latest+1];

        for(int i=0;i<=latest;i++){
            tempValues[i] = values[i];
        }
        return tempValues;
    }
}
