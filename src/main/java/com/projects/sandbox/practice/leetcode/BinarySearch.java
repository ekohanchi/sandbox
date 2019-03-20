package com.projects.sandbox.practice.leetcode;

public class BinarySearch {

	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		
		bs.doSearch();
		//bs.doSqrt();
		//bs.doGuessNumber();
		
	}
	
	public void doSearch() {
		int[] nums = new int[] {-1,0,3,5,9,12};
		int target = 5;
		//int target = 2;
		
		System.out.println(search(nums, target));
	}
	
	public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end -start) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            
            if(target < nums[mid]) {
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }
        
        return -1;
    }
	
	public void doSqrt() {
		int num = 10;
		System.out.println(mySqrt(num));
	}
	
	public int mySqrt(int x) {
		if(x == 0) {
            return 0;
        }
        
        int left = 1;
        int right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left) / 2;
            
            if(mid > x/mid) {
                right = mid - 1;
            } else {
                if (mid+1 > x/(mid+1)) {
                    return mid;
                }
                left = mid + 1;
            }
        }
	}


	public void doGuessNumber() {
		guessNumber(2126753390);
	}
	private int guess(int num) {
		int target = 1702766719;
		if(num == target) {
			return 0;
		} else if (num < target) {
			return 1;
		} else {
			return -1;
		}
	}
	public int guessNumber(int n) {
        int start=1;
        //n=end
        while(start <= n) {
            int mid = start + (n - start)/2;
            int guessResult = guess(mid);
            if (guessResult == 0) {
                return mid;
            }
            
            if (guessResult == -1) {
                n = mid -1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
