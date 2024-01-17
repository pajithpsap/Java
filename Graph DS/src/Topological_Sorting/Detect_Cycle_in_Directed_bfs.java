//{ Driver Code Starts
package Topological_Sorting;
import java.util.*;
import java.io.*;
import java.lang.*;

class Detect_Cycle_in_Directed_bfs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution2().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution2 {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
    	Queue<Integer> q = new LinkedList<Integer>();
		int[] indegree = new int[V];
		//int[] ans = new int[V];
		for (int i = 0; i < V; i++) {
			for (Integer it : adj.get(i)) {
				indegree[it]++;
			}
		}
		for (int i = 0; i < V; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}
		int j = 0;
		while (!q.isEmpty()) {
			int node = q.peek();
			q.remove();
			//ans[j++] = node;
			j++;

			for (Integer it : adj.get(node)) {
				indegree[it]--;
				if (indegree[it] == 0) {
					q.add(it);
				}
			}
		}
		if(j == V) return true;
		
		return false;
    }
}