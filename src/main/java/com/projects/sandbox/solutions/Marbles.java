package com.projects.sandbox.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Marbles {	
	int m = 5;
	int n = 10;
	int[][] board = new int [m][n];

	/*
	public void removeMarbles() {
		int m = 5;
		int n = 10;
		
		
		
//		List<Integer> rowCount = new ArrayList<Integer> ();
		HashMap<Integer, Integer> rowCount = new HashMap<Integer, Integer>();
		int colCount = 0;
		// rows
		
		int[][] rows;
		int[][] cols;
		vector<MarbleInfo> marbles;
		
		for(int i=0; i<m; i++) {
			// columns
			for (int j=0; j<n; j++) {
				if (board[i][j] = 1) {
					rows[i].insert(j);
					col[j].insert(i);
					marbles.insert(MarbleInfo(i,j,0));
				}
				//if(scanAllCols(row))
				
				
//				if(board[i][j] == 1) {
//					rowCount.put(i, )
//				}
				
				
			}
		}
		MinHeap<int, MarbleInfo> heap;
		foreach(mableinfo : marbles) {
			marbleinfo.degree = length(row[marble_info.x]) + leng(col[marble_info.y]) - 2;
			if (degree > 0) {
				heap.add(degree, marbleInfo);
			}
		}
		
		// recursion
		// leetcode
		
		
		
	}
	
	public int scanAllRows(int col) {
		int count = 0;
		for (int i=0; i<m; i++) {
			if(board[i][col] == 1) {
				count++;
			}
		}
		return count;	
	}
	
	public int scanAllCols(int row) {
		int count = 0;
		for (int j=0; j<n; j++) {
			if(board[row][j] == 1 {
				count++;
			}
		}
		return count;
	}
	*/

}

class MarbleInfo
{
	int x_coord;
	int y_coord;
	int degree;
}
