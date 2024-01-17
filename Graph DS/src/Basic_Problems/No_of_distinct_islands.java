package Basic_Problems;

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

//Position this line where user code will be pasted.

class No_of_distinct_islands {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] grid = new int[n][m];

			for (int i = 0; i < n; i++) {

				for (int j = 0; j < m; j++) {
					grid[i][j] = sc.nextInt();
				}
			}

			Solution11 ob = new Solution11();
			int ans = ob.countDistinctIslands(grid);
			System.out.println(ans);
		}
	}
}
//} Driver Code Ends

//User function Template for Java

class Solution11 {
	public static void dfs(int row, int col, int[][] grid, ArrayList<String> lt, int[][] vis, int row0, int col0) {
		int n = grid.length;
		int m = grid[0].length;
		vis[row][col] = 1;
		lt.add((row - row0) + "," + (col - col0));
		int[] drow = { -1, 0, 1, 0 };
		int[] dcol = { 0, 1, 0, -1 };

		for (int i = 0; i < 4; i++) {
			int nrow = row + drow[i];
			int ncol = col + dcol[i];

			if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && vis[nrow][ncol] == 0
					&& grid[nrow][ncol] == 1) {
				dfs(nrow, ncol, grid, lt, vis, row0, col0);
			}
		}
	}

	int countDistinctIslands(int[][] grid) {

		int n = grid.length;
		int m = grid[0].length;

		int[][] vis = new int[n][m];
		HashSet<ArrayList<String>> hs = new HashSet<ArrayList<String>>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (vis[i][j] != 1 && grid[i][j] == 1) {
					ArrayList<String> lt = new ArrayList<String>();
					dfs(i, j, grid, lt, vis, i, j);
					hs.add(lt);
				}
			}
		}
		return hs.size();
	}
}
