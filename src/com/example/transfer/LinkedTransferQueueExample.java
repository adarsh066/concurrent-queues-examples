package com.example.transfer;

import java.util.concurrent.LinkedTransferQueue;

/**
 * Example demonstrating usage of LinkedTransferQueue.
 * Author: Aadarsh Patil
 */
public class LinkedTransferQueueExample {

	public static void main(String[] args) throws InterruptedException {
		LinkedTransferQueue<String> transferQueue = new LinkedTransferQueue<>();

		// Adding elements to the transfer queue
		transferQueue.put("First element");
		transferQueue.put("Second element");
		transferQueue.put("Third element");

		// Transferring elements between threads
		new Thread(() -> {
			try {
				String element = transferQueue.take();
				System.out.println("Consumed element in Thread 1: " + element);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		transferQueue.transfer("Fourth element");

		new Thread(() -> {
			try {
				String element = transferQueue.take();
				System.out.println("Consumed element in Thread 2: " + element);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
}
