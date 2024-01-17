package Basic_Problems;

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

//Position this line where user code will be pasted.

public class Eventual_safe_states {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int V = sc.nextInt();
			int E = sc.nextInt();

			List<List<Integer>> adj = new ArrayList<>();

			for (int i = 0; i < V; i++) {
				adj.add(new ArrayList<>());
			}
			for (int i = 0; i < E; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();

				adj.get(u).add(v);
			}

			Solution14 obj = new Solution14();
			List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
			for (int i : safeNodes) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
//} Driver Code Ends

//User function Template for Java

class Solution14 {

	public static boolean dfs(int node, List<List<Integer>> adj, int[] vis, int[] pathVis, int[] check) {
		vis[node] = 1;
		pathVis[node] = 1;
		check[node] = 0;

		for (Integer it : adj.get(node)) {
			if (vis[it] != 1) {
				if (dfs(it, adj, vis, pathVis, check) == true)
					return true;
			} else {
				if (pathVis[it] == 1)
					return true;
			}
		}
		pathVis[node] = 0;
		check[node] = 1;
		return false;
	}

	List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

		List<Integer> ans = new ArrayList<Integer>();
		int[] vis = new int[V];
		int[] pathVis = new int[V];
		int[] check = new int[V];

		for (int i = 0; i < V; i++) {
			if (vis[i] != 1) {
				dfs(i, adj, vis, pathVis, check);
			}
		}

		for (int i = 0; i < V; i++) {
			if (check[i] == 1) {
				ans.add(i);
			}
		}
		return ans;
	}
}
