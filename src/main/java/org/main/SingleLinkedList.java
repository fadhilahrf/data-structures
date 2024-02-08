package org.main;

public class SingleLinkedList <T> {
    class Node {
        public T value;
        public Node next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;

    private Node tail;

    private int size = 0;

    public SingleLinkedList(T[] array) {
        for(T value: array) {
            insert(value);
        }
    }

    public SingleLinkedList() {}

    public void insert(T value) {
        Node node = new Node(value);

        if(head == null && tail==null){
            head = node;
            tail = head;
        }else {
            tail.next = node;
            tail = tail.next;
        }
        size++;
    }

    public void insertAfter(int index, T value) {
        try {
            if(index>=size) {
                throw new Exception("Index out of bounds");
            }
        }catch (Exception e) {

        }

        int counter = 0;
        Node newNode = new Node(value);

        Node node = head;
        while (node != null && counter != index) {
            node = node.next;
            counter++;
        }
        newNode.next = node.next;
        node.next = newNode;

        size++;
    }

    public void remove(int index) {
        try {
            if(index>=size) {
                throw new Exception("Index out of bounds");
            }
        }catch (Exception e) {

        }

        int counter = 0;

        Node node = head;
        Node previousNode = head;
        while (node != null && counter != index) {
            previousNode = node;
            node = node.next;
            counter++;
        }

        previousNode.next = previousNode.next.next;
        node = null;

        size--;
    }

    public T get(int index) {
        try {
            if(index>=size) {
                throw new Exception("Index out of bounds");
            }
        }catch (Exception e) {

        }

        int counter = 0;

        Node node = head;
        while (node != null && counter != index) {
            node = node.next;
            counter++;
        }

        return node.value;
    }

    public void set(int index, T value) {
        try {
            if(index>=size) {
                throw new Exception("Index out of bounds");
            }
        }catch (Exception e) {

        }

        int counter = 0;

        Node node = head;
        while (node != null && counter != index) {
            node = node.next;
            counter++;
        }

        node.value = value;
    }

    public int size() {
        return size;
    }

    public T[] toArray() {
        T[] arr = (T[]) new Object[size];

        Node node = head;
        int counter = 0;
        while (node != null) {
            arr[counter] = node.value;
            node = node.next;
            counter++;
        }

        return arr;
    }
}
