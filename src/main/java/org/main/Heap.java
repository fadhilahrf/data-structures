package org.main;

import java.util.ArrayList;

public class Heap {

    public static String MAX = "MAX";

    public static String MIN = "MIN";

    private String type;

    private java.util.ArrayList<Integer> heapList = new ArrayList<>();

    public Heap(String type) {
        this.type = type;
    }

    private void maxHeapify(int i) {
        int size = heapList.size();
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < size && heapList.get(l) > heapList.get(largest))
            largest = l;
        if (r < size && heapList.get(r) > heapList.get(largest))
            largest = r;

        if (largest != i) {
            int temp = heapList.get(largest);
            heapList.set(largest, heapList.get(i));
            heapList.set(i, temp);

            maxHeapify(largest);
        }

    }

    private void minHeapify(int i) {
        int size = heapList.size();
        int smallest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < size && heapList.get(l) < heapList.get(smallest))
            smallest = l;
        if (r < size && heapList.get(r) < heapList.get(smallest))
            smallest = r;

        if (smallest != i) {
            int temp = heapList.get(smallest);
            heapList.set(smallest, heapList.get(i));
            heapList.set(i, temp);

            minHeapify(smallest);
        }
    }

    public void insert(int newNum) {
        int size = heapList.size();
        if (size == 0) {
            heapList.add(newNum);
        } else {
            heapList.add(newNum);
            for (int i = size / 2 - 1; i >= 0; i--) {
                if(this.type==MAX) {
                    maxHeapify(i);
                }else{
                    minHeapify(i);
                }
            }
        }
    }

    public void delete(int num)
    {
        int size = heapList.size();
        int i;
        for (i = 0; i < size; i++)
        {
            if (num == heapList.get(i)) {
                break;
            }
        }
        try {
            int temp = heapList.get(i);
            heapList.set(i, heapList.get(size-1));
            heapList.set(size-1, temp);

            heapList.remove(size-1);
            for (int j = size / 2 - 1; j >= 0; j--)
            {
                if(this.type==MAX) {
                    maxHeapify(i);
                }else{
                    minHeapify(i);
                }
            }
        }catch (IndexOutOfBoundsException e) {
            System.out.println("value not found");
        }
    }

    public int totalNode() {
        return heapList.size();
    }

    public Integer[] toArray() {
        Integer[] heapArray = new Integer[heapList.size()];
        return heapList.toArray(heapArray);
    }
}
