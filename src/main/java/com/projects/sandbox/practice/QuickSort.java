package com.projects.sandbox.practice;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
	public static void main(String args[]) {
		int arr[] = {10, 7, 8, 9, 1, 5};
		int n = arr.length;
		
		System.out.println("UnSorted Array");
		printyArray(arr);
		
		QuickSort qs = new QuickSort();
		qs.sort(arr, 0, n-1);
		
		System.out.println("Sorted Array");
		printyArray(arr);
	}
	
	/**
	 * This function takes last element as pivot, 
       places the pivot element at its correct 
       position in sorted array, and places all 
       smaller (smaller than pivot) to left of 
       pivot and all greater elements to right 
       of pivot
       
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
	int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		
		int i = (low - 1); 	// Index of smaller element
		for (int j=low; j<high; j++) {
			if (arr[j] <= pivot) {
				i++;
				
				// swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		// swap arr[i+1] and arr[high] (or pivot)
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		
		return i+1;
	}
	
	void sort(int arr[], int low, int high) {
		if (low < high) {
			// pi is partitioning index, arr[pi] is now at the right place
			int pi = partition(arr, low, high);
			
			// Recursively sort elements before partition and after partition.
			sort(arr, low, pi-1);
			sort(arr, pi+1, high);
		}
	}
	
	static void printyArray(int arr[]) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
