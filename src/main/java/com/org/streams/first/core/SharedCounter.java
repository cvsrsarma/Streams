package com.org.streams.first.core;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SharedCounter {
	private int count = 0;

	public  void increment() {
        count++;
    }    public int getCount() {
        return count;
    }    public static void main(String[] args) {
        final SharedCounter counter = new SharedCounter();        
        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        };        
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);        
        thread1.start();
        thread2.start();        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }        System.out.println("Final Count: " + counter.getCount());
        
        
int numElements = 1000000;
        
        long startTime = System.nanoTime();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < numElements; i++) {
            hashSet.add(i);
        }
        long endTime = System.nanoTime();
        long hashSetTime = endTime - startTime;
        
        startTime = System.nanoTime();
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        for (int i = 0; i < numElements; i++) {
            linkedHashSet.add(i);
        }
        endTime = System.nanoTime();
        long linkedHashSetTime = endTime - startTime;
        
        startTime = System.nanoTime();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < numElements; i++) {
            treeSet.add(i);
        }
        endTime = System.nanoTime();
        long treeSetTime = endTime - startTime;
        
        System.out.println("HashSet Time (ns): " + hashSetTime);
        System.out.println("LinkedHashSet Time (ns): " + linkedHashSetTime);
        System.out.println("TreeSet Time (ns): " + treeSetTime);
    }
}
