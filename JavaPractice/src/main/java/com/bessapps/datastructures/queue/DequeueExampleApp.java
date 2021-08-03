package com.bessapps.datastructures.queue;

import java.util.ArrayDeque;
import java.util.Deque;

class MyDequeue<E> {
    Deque<E> myDequeue = new ArrayDeque<>();

    public void addToQueue(E s) {
        myDequeue.push(s);
    }

    public E getLast() {
        return myDequeue.getLast();
    }

    public E getFirt() {
        return myDequeue.getFirst();
    }

    public E poll() {
        return myDequeue.poll();
    }

    public E pollLast() {
        return myDequeue.pollFirst();
    }

    @Override
    public String toString() {
        return "MyDequeue{" +
                "myDequeue=" + myDequeue +
                '}';
    }
}

public class DequeueExampleApp {

    public static void main(String[] args) {
        MyDequeue myDequeue = new MyDequeue();

        myDequeue.addToQueue("first");
        myDequeue.addToQueue("second");
        myDequeue.addToQueue("third");
        myDequeue.addToQueue("fourth");
        myDequeue.addToQueue("fifth");

        System.out.println(myDequeue.getFirt());
        System.out.println(myDequeue.getLast());
        System.out.println(myDequeue.toString());
        System.out.println(myDequeue.getFirt());
        System.out.println(myDequeue.getLast());
        System.out.println(myDequeue.toString());
        /*
        System.out.println(myDequeue.poll());
        System.out.println(myDequeue.poll());
        System.out.println(myDequeue.toString());
        */
        System.out.println(myDequeue.pollLast());
        System.out.println(myDequeue.toString());
    }

}
