package com.bessapps.datastructures.priorityqueues;

import java.util.PriorityQueue;

public class FirstPriorityQueue {
    //Creating the Priority Queue
    static PriorityQueue<Integer> pQueue = new PriorityQueue<>();

    public static void main(String args[]) {

        pQueue.add(100);
        pQueue.add(1);
        pQueue.add(32);
        pQueue.add(633);
        pQueue.add(50);
        pQueue.add(4852);
        pQueue.add(11);
        pQueue.add(54);
        pQueue.add(21);
        pQueue.add(95);
        pQueue.add(5347);
        pQueue.add(84344);
        pQueue.add(7345);
        pQueue.add(324);
        pQueue.add(32);
        pQueue.add(576);

        // Peeking operation - returns the first (top) element but will not remove it..
        System.out.println("Peeking the queue");
        System.out.println(pQueue);
        System.out.println(pQueue.peek());
        System.out.println(pQueue);
        System.out.println("Size of the queue: " + pQueue.size());

        pollElements(5);
        // Peeking operation - returns the true if i can remove it..

        System.out.println("Removing the queue");
        System.out.println(pQueue);
        System.out.println(pQueue.remove(7345));
        System.out.println(pQueue);

        // Offer operation  which is adding to queueue....
        System.out.println("Offer operation..");
        System.out.println(pQueue);
        System.out.println("Offer: " + pQueue.offer(3));
        System.out.println(pQueue);

        System.out.println("Size of the queue: " + pQueue.size());



    }

    public static void pollElements(int num) {
        // Peeking operation - returns the first element but will remove it..
        System.out.println("Polling the queue");
        System.out.println(pQueue);
        for(int i = 0; i < num; i++) System.out.println("Poll: " + pQueue.poll());
        System.out.println(pQueue);
    }

}
