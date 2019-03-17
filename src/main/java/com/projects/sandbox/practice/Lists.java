package com.projects.sandbox.practice;

import java.util.ArrayList;
import java.util.LinkedList;

public class Lists {
	public static void main(String[] args) {
		linkedListPractice();
		arrayListPractice();
	}
	
	private static void linkedListPractice() {
		LinkedList<String> sampleLL = new LinkedList<String>();
		sampleLL.add("A");
		sampleLL.add("B");
		sampleLL.add("C");
		sampleLL.add("D");
		sampleLL.add("E");
		sampleLL.add("F");
		sampleLL.add("G");
		sampleLL.addFirst("FIRST");
		sampleLL.addLast("LAST");
		sampleLL.addFirst("FIRST2");
		sampleLL.remove("C");
		sampleLL.removeLast();
		sampleLL.removeFirst();
		
		System.out.println("Value of LinkedList: " + sampleLL);
	}
	
	private static void arrayListPractice() {
		ArrayList<String> sampleAL = new ArrayList<String>();
		sampleAL.add("A");
		sampleAL.add("B");
		sampleAL.add("C");
		sampleAL.add("D");
		sampleAL.add("E");
		sampleAL.add("F");
		sampleAL.add("G");
		sampleAL.add(2, "C2");
		sampleAL.set(0, "A2");
		sampleAL.remove(sampleAL.size()-1);
		
		System.out.println("Values of ArrayList: " + sampleAL);
	}
}
