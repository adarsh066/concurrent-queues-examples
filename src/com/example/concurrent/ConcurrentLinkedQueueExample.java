package com.example.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Example demonstrating usage of ConcurrentLinkedQueue.
 * Author: Aadarsh Patil
 */
public class ConcurrentLinkedQueueExample {

	public static void main(String[] args) {
		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

		// Adding elements to the queue
		queue.offer("First element");
		queue.offer("Second element");
		queue.offer("Third element");

		// Removing elements from the queue
		String element1 = queue.poll(); // Removes and returns the head of the queue
		String element2 = queue.peek(); // Retrieves but does not remove the head of the queue

		System.out.println("Removed element: " + element1);
		System.out.println("Peeked element: " + element2);
	}
}
