package Basic_Problems;

//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class BFS {
 public static void main(String[] args) throws IOException {
     BufferedReader br =
         new BufferedReader(new InputStreamReader(System.in));
     int T = Integer.parseInt(br.readLine().trim());
     while (T-- > 0) {
         String[] s = br.readLine().trim().split(" ");
         int V = Integer.parseInt(s[0]);
         int E = Integer.parseInt(s[1]);
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
         for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
         for (int i = 0; i < E; i++) {
             String[] S = br.readLine().trim().split(" ");
             int u = Integer.parseInt(S[0]);
             int v = Integer.parseInt(S[1]);
             adj.get(u).add(v);
             // adj.get(v).add(u);
         }
         Solution1 obj = new Solution1();
         ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
         for (int i = 0; i < ans.size(); i++)
             System.out.print(ans.get(i) + " ");
         System.out.println();
     }
 }
}

//} Driver Code Ends


class Solution1 {
 // Function to return Breadth First Traversal of given graph.
 public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
     // Code here
     int[] vis = new int[V];
     vis[0] = 1;
     ArrayList<Integer> bfs = new ArrayList<Integer>();
     Queue<Integer> q = new LinkedList<Integer>();
     
     q.add(0);
     
     while(!q.isEmpty()){
         int p = q.poll();
         bfs.add(p);
         
         for(int i = 0; i < adj.get(p).size(); i++){
             int e = adj.get(p).get(i);
             
             if(vis[e] != 1){
                 vis[e] = 1;
                 q.add(e);
             }
         }
     }
     return bfs;
 }
}