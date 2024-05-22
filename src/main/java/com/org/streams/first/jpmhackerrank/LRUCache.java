package com.org.streams.first.jpmhackerrank;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	    class DListNode {
	        int key;
	        int value;
	        DListNode prev;
	        DListNode next;
	    }

	    private Map<Integer, DListNode> cache;
	    private int size;
	    private int capacity;
	    private DListNode head;
	    private DListNode tail;

	    public LRUCache(int capacity) {
	        this.capacity = capacity;
	        this.cache = new HashMap<>();
	        this.size = 0;
	        this.head = new DListNode();
	        this.tail = new DListNode();
	        head.next = tail;
	        tail.prev = head;
	    }

	    private void addNode(DListNode node) {
	        node.prev = head;
	        node.next = head.next;
	        head.next.prev = node;
	        head.next = node;
	    }

	    private void removeNode(DListNode node) {
	        node.prev.next = node.next;
	        node.next.prev = node.prev;
	    }

	    private void moveToHead(DListNode node) {
	        removeNode(node);
	        addNode(node);
	    }

	    private DListNode popTail() {
	        DListNode node = tail.prev;
	        removeNode(node);
	        return node;
	    }

	    public int get(int key) {
	        DListNode node = cache.get(key);
	        if (node == null) {
	            return -1;
	        }
	        moveToHead(node);
	        return node.value;
	    }

	    public void put(int key, int value) {
	        DListNode node = cache.get(key);
	        if (node == null) {
	            node = new DListNode();
	            node.key = key;
	            node.value = value;
	            cache.put(key, node);
	            addNode(node);
	            size++;
	            if (size > capacity) {
	                DListNode tail = popTail();
	                cache.remove(tail.key);
	                size--;
	            }
	        } else {
	            node.value = value;
	            moveToHead(node);
	        }
	    }


}
