package Basic_Problems;

//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class DFS {
 public static void main(String[] args) throws IOException {
     BufferedReader br =
         new BufferedReader(new InputStreamReader(System.in));
     int T = Integer.parseInt(br.readLine().trim());
     while (T-- > 0) {
         String[] s = br.readLine().trim().split(" ");
         int V = Integer.parseInt(s[0]);
         int E = Integer.parseInt(s[1]);
         ArrayList<ArrayList<Integer>> adj =
             new ArrayList<ArrayList<Integer>>();
         for (int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());
         for (int i = 0; i < E; i++) {
             String[] S = br.readLine().trim().split(" ");
             int u = Integer.parseInt(S[0]);
             int v = Integer.parseInt(S[1]);
             adj.get(u).add(v);
             adj.get(v).add(u);
         }
         Solution2 obj = new Solution2();
         ArrayList<Integer> ans = obj.dfsOfGraph(V, adj);
         for (int i = 0; i < ans.size(); i++)
             System.out.print(ans.get(i) + " ");
         System.out.println();
     }
 }
}

//} Driver Code Ends


class Solution2 {
	
	public static void dfs_search(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, ArrayList<Integer> dfs) {
		vis[node] = 1;
		dfs.add(node);
		
		for(Integer it : adj.get(node)) {
			if(vis[it] == 0) {
				dfs_search(it, adj, vis, dfs);
			}
		}
		
	}
 // Function to return a list containing the DFS traversal of the graph.
 public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
     // Code here
	 int[] vis = new int[V];
	 vis[0] = 1;
	 ArrayList<Integer> dfs = new ArrayList<Integer>();
	 dfs_search(0, adj, vis, dfs);
	 return dfs;
 }
}