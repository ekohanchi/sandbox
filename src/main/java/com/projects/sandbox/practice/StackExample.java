package com.projects.sandbox.practice;

import java.util.Stack;

public class StackExample {
	private static int MAX_NUM = 5;
	
	// pushing elements to the top of the stack
	static void stack_push(Stack<Integer> stack) {
		System.out.println("Pushing elements to the stack: " );
		for(int i=0; i<MAX_NUM; i++) {
			System.out.println(i);
			stack.push(i);
		}
	}
	
	// popping elements from top of the stack
	static void stack_pop(Stack<Integer> stack) {
		System.out.println("POP: " );
		
		for(int i=0; i<MAX_NUM; i++) {
			System.out.println(stack.pop());
		}
	}
	
	// peeking at the element on top of the stack
	static void stack_peek(Stack<Integer> stack) {
		System.out.println("Element on top of the stack: " + stack.peek());
	}
	
	// Searching for an element in the stack
	static void stack_search(Stack<Integer> stack, int element) {
		int pos = stack.search(element);
		
		if (pos == -1) {
			System.out.println("Element specified [" + element + "] not found");
		} else {
			System.out.println("Element specified [" + element + "] is at position: " + pos);
		}
	}
	
	public static void main (String[] args) 
    { 
        Stack<Integer> stack = new Stack<Integer>(); 
  
        stack_push(stack); 
        stack_pop(stack); 
        stack_push(stack); 
        stack_peek(stack); 
        stack_search(stack, 2); 
        stack_search(stack, 6); 
    } 
	

}
