package com.example.delay;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Example demonstrating usage of DelayQueue.
 * Author: Aadarsh Patil
 */
public class DelayQueueExample {

	static class DelayedElement implements Delayed {
		private String name;
		private long delayTime;

		DelayedElement(String name, long delayTime) {
			this.name = name;
			this.delayTime = System.currentTimeMillis() + delayTime;
		}

		@Override
		public long getDelay(TimeUnit unit) {
			long diff = delayTime - System.currentTimeMillis();
			return unit.convert(diff, TimeUnit.MILLISECONDS);
		}

		@Override
		public int compareTo(Delayed o) {
			long diff = this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS);
			return Long.compare(diff, 0);
		}

		@Override
		public String toString() {
			return "DelayedElement{" + "name='" + name + '\'' + ", delayTime=" + delayTime + '}';
		}
	}

	public static void main(String[] args) throws InterruptedException {
		DelayQueue<DelayedElement> delayQueue = new DelayQueue<>();

		// Adding delayed elements to the queue
		delayQueue.put(new DelayedElement("Element 1", 2000));
		delayQueue.put(new DelayedElement("Element 2", 1000));
		delayQueue.put(new DelayedElement("Element 3", 3000));

		// Retrieving elements from the queue after their delay time
		System.out.println("DelayQueue elements:");
		while (!delayQueue.isEmpty()) {
			DelayedElement element = delayQueue.take();
			System.out.println(element);
		}
	}
}
