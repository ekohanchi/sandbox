package com.projects.sandbox.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LeetCode {
	public static void main(String[] args) {
		String J = "AbaA";
		String S = "dagadGWAGBsgas";

		System.out.print(numJewelsInStones(J, S));
	}

	/**
	 * Learnings - Level: Easy
	 * - Character vs char
	 * - length vs length() for an array
	 * 
	 */
	public static int numJewelsInStones(String J, String S) {
		char[] jCharArray = J.toCharArray();
		char[] sCharArray = S.toCharArray();
		ArrayList<Character> processed = new ArrayList<Character>();

		int jewelCount = 0;
		for (int jewel = 0; jewel < jCharArray.length; jewel++) {
			for (int stone = 0; stone < sCharArray.length; stone++) {
				if ((jCharArray[jewel] == sCharArray[stone]) && !processed.contains(jCharArray[jewel])) {
					jewelCount++;
				}
			}
			processed.add(jCharArray[jewel]);
		}
		return jewelCount;
	}
	
	/**
	 * Learnings - Level: Medium
	 * TODO - Note yet completed
	 */
	public List<List<Integer>> fourSum(int[] nums, int target) {
		// Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
        List<Integer> quadSumTarget = new ArrayList<Integer>();
        List<List<Integer>> allSumTarget = new ArrayList<List<Integer>>();
        
        // if length of nums array is less than 4 output a message and return null
        if(nums.length <4) {
            System.out.println("Can't proceed, length of given array is less than 4: " + nums.length);  
            return null;
        }
        
        // 1 - sort nums array into a sorted list
        // [-2, -1, 0, 0, 1, 2]
        Arrays.sort(nums);

        int sum=0;
        for(Integer num : nums) {
            sum += num;
            if(sum<=target) {
                quadSumTarget.add(num);
                if(sum==target) {
                    break;
                }
            }
            allSumTarget.add(quadSumTarget);
            
        }
        return allSumTarget;
    }
	
    static class Node {
        int value;
        Node left;
        Node right;
        
        Node (int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }
    
    /**
     * Learnings - Level: Easy
     * - HashMap must contain key & value not just key
     */
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++) {
            numsMap.put(nums[i], 1);
        }
        if(nums.length != numsMap.size()) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Learnings - Level: Easy
     * - 2 conditions can be provided to for loop
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        
        boolean found = false;
        for(int i=0; i<nums.length && !found; i++) {
            int potential = nums[i];
            for(int j=i+1; j<nums.length; j++) {
                if(nums[j] == (target - potential)) {
                    result[0] = i;
                    result[1] = j;
                    found = true;
                    break;
                }
            }
        }
        return result;
    }
    
	

}
