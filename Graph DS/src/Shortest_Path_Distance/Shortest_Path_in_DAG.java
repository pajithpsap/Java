package Shortest_Path_Distance;

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

public class Shortest_Path_in_DAG {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m, edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
//} Driver Code Ends

class Pair {
	int f;
	int s;

	Pair(int a, int b) {
		this.f = a;
		this.s = b;
	}
}

//User function Template for Java
class Solution {
	// dfs --> topoSort

	public static void dfs(int node, ArrayList<ArrayList<Pair>> adj, int[] vis, Stack<Integer> st) {
		vis[node] = 1;

		for (int i = 0; i < adj.get(node).size(); i++) {
			int v = adj.get(node).get(i).f;
			if (vis[v] == 0) {
				dfs(v, adj, vis, st);
			}
		}
		st.add(node);
	}

	public int[] shortestPath(int N, int M, int[][] edges) {
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			ArrayList<Pair> temp = new ArrayList<Pair>();
			adj.add(temp);
		}
		for (int i = 0; i < M; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			int wt = edges[i][2];
			adj.get(i).add(new Pair(v, wt));
		}

		Stack<Integer> st = new Stack<Integer>();
		int[] vis = new int[N];
		int[] dis = new int[N];
		Arrays.fill(dis, (int) (1e9));
		// dfs

		for (int i = 0; i < N; i++) {
			if (vis[i] == 0) {
				dfs(i, adj, vis, st);
			}
		}
		dis[0] = 0;
		while (!st.isEmpty()) {
			int node = st.peek();
			st.pop();

			for (int i = 0; i < adj.get(node).size(); i++) {
				int v = adj.get(node).get(i).f;
				int wt = adj.get(node).get(i).s;
				if (dis[node] + wt < dis[v]) {
					dis[v] = dis[node] + wt;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			if (dis[i] == 1e9)
				dis[i] = -1;
		}
		return dis;
	}
}