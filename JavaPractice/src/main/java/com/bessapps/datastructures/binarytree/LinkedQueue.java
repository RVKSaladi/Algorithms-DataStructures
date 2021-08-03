package com.bessapps.datastructures.binarytree;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedQueue<Key> implements Queue<Key> {
    private LinkedList<Key> list = new LinkedList<>(); // an empty list public LinkedQueue() { } // new queue relies on the initially empty list public int size() { return list.size(); }

    @Override
    public int size() {
        return 0;
    }

    public boolean isEmpty() { return list.isEmpty(); }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Key> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    public void enqueue(Key element) { list.addLast(element); }
    //public Key first() { return list.first(); }
    public Key dequeue() { return list.removeFirst(); }

    @Override
    public boolean add(Key key) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Key> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean offer(Key key) {
        return false;
    }

    @Override
    public Key remove() {
        return null;
    }

    @Override
    public Key poll() {
        return null;
    }

    @Override
    public Key element() {
        return null;
    }

    @Override
    public Key peek() {
        return null;
    }
}