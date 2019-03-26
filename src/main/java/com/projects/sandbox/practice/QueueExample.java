package com.projects.sandbox.practice;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=0; i<5; i++) {
			queue.add(i);
		}
		
		System.out.println("Elements of the queue: " + queue);
		
		int headOFQueue = queue.remove();
		System.out.println("Removed Element: " + headOFQueue);
		
		System.out.println("Elements of the queue: " + queue);
		
		int peekHeadOFQueue = queue.peek();
		System.out.println("Head of queue: " + peekHeadOFQueue);
		
		System.out.println("Size of the queue: " + queue.size());

	}

}
