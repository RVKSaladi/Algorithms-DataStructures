package com.bessapps.datastructures.priorityqueues;

import java.util.Collections;
import java.util.PriorityQueue;

public class SecondPriorityQueue_ReverseOrder {
    public static PriorityQueue<Integer> myPQueue = new PriorityQueue<>(Collections.reverseOrder());

    public  boolean add(int x) throws IllegalStateException {
        return myPQueue.add(x);
    }

    public void offer(int...x) {
        for(int i:  x) myPQueue.offer(i);
    }

    public boolean remove(int x) {
        return myPQueue.remove(x);
    }

    public void poll(int num) {
        for(int i = 0; i < num; i++) {
            System.out.print(myPQueue.poll() + " ");
        }
        System.out.println();
    }

    public int getSize() {
        return myPQueue.size();
    }

    public PriorityQueue<Integer> getMyPQueue() {
        return myPQueue;
    }

    public void peek() {
        System.out.println(myPQueue.peek());
    }

}

class App {
    public static void main(String args[]) {
        SecondPriorityQueue_ReverseOrder pq = new SecondPriorityQueue_ReverseOrder();

        pq.offer(-100,-98,-1,2,3,4);

        System.out.println(pq.getMyPQueue());
        pq.peek();
        System.out.println(pq.getMyPQueue());

        pq.poll(3);
        System.out.println(pq.getMyPQueue());

        pq.offer(200);
        System.out.println(pq.getMyPQueue());
        pq.poll(1);
        System.out.println(pq.getMyPQueue());
        pq.offer(200);
        System.out.println(pq.getMyPQueue());
        pq.poll(1);


    }
}
