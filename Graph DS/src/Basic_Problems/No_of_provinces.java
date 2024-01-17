package Basic_Problems;

//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class No_of_provinces {
	public static void main(String args[]) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());
		while (t-- > 0) {
			int V = Integer.parseInt(read.readLine());

			ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

			for (int i = 0; i < V; i++) {
				String S[] = read.readLine().split(" ");
				ArrayList<Integer> temp = new ArrayList<>();
				for (int j = 0; j < V; j++)
					temp.add(Integer.parseInt(S[j]));
				adj.add(temp);
			}

			Solution3 ob = new Solution3();
			System.out.println(ob.numProvinces(adj, V));
		}
	}
}
//} Driver Code Ends

//User function Template for Java

class Solution3 {
	static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
		ArrayList<ArrayList<Integer>> adj_list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < V; i++) {
			adj_list.add(new ArrayList<Integer>());
		}
		int[] vis = new int[V];

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if (adj.get(i).get(j) == 1 && i != j) {
					adj_list.get(i).add(j);
					adj_list.get(j).add(i);
				}
			}
		}
		// counting the provinces
		int count = 0;
		for (int i = 0; i < V; i++) {
			if (vis[i] == 0) {
				count++;
				dfs(i, adj_list, vis);
			}
		}
		return count;
	}

	public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis) {
		vis[node] = 1;

		for (Integer it : adj.get(node)) {
			if (vis[it] == 0) {
				dfs(it, adj, vis);
			}
		}
	}

};