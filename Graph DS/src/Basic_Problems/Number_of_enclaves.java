package Basic_Problems;

//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

//Position this line where user code will be pasted.

class Number_of_enclaves {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String s[] = in.readLine().trim().split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			int a[][] = new int[n][m];
			for (int i = 0; i < n; i++) {
				s = in.readLine().trim().split(" ");
				for (int j = 0; j < m; j++) {
					a[i][j] = Integer.parseInt(s[j]);
				}
			}
			Solution10 ob = new Solution10();
			out.println(ob.numberOfEnclaves(a));
		}
		out.close();
	}
}
//} Driver Code Ends

//User function Template for Java
class Pair9 {
	int first;
	int second;

	Pair9(int n1, int n2) {
		this.first = n1;
		this.second = n2;
	}
}

class Solution10 {

	int numberOfEnclaves(int[][] grid) {

		int n = grid.length, m = grid[0].length;
		int[][] vis = new int[n][m];

		int[] drow = { -1, 0, 1, 0 };
		int[] dcol = { 0, 1, 0, -1 };

		Queue<Pair9> q = new LinkedList<Pair9>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// first row, first col, last row, last col
				if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
					// if it is a land then store it in queue
					if (grid[i][j] == 1) {
						q.add(new Pair9(i, j));
						vis[i][j] = 1;
					}
				}
			}
		}

		while (!q.isEmpty()) {
			int row = q.peek().first;
			int col = q.peek().second;
			q.remove();

			for (int i = 0; i < 4; i++) {
				int nrow = row + drow[i];
				int ncol = col + dcol[i];

				if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
					vis[nrow][ncol] = 1;
					q.add(new Pair9(nrow, ncol));
				}
			}
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (vis[i][j] != 1 && grid[i][j] == 1) {
					count++;
				}
			}
		}
		return count;

	}
}