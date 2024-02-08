package org.main;

public class Stack <T> {

    private T[] values;
    private int top = -1;

    private int maxSize = 0;

    public Stack(int maxSize) {
        values = (T[]) new Object[maxSize];
        this.maxSize = maxSize;
    }

    public Stack() {
        this.maxSize = 10;
        values = (T[]) new Object[this.maxSize];
    }

    public void push(T value) {
        try {
            if(isFull()) {
                throw new Exception("Stack is full");
            }
        }catch (Exception e) {

        }

        top++;
        values[top] = value;
    }

    public T pop() {
        if(top!=-1) {
            T value = values[top];
            values[top] = null;
            top--;
            return value;
        }
        return null;
    }

    public T peek() {
        return values[top];
    }

    public boolean isEmpty() {
        if(top==-1) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if(top==maxSize-1){
            return true;
        }
        return false;
    }

    public T[] toArray() {
        T[] tempValues = (T[]) new Object[top+1];

        for(int i=0;i<=top;i++){
            tempValues[i] = values[i];
        }
        return tempValues;
    }
}
