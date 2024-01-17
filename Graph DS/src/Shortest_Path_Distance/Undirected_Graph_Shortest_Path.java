package Shortest_Path_Distance;




//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
public class Undirected_Graph_Shortest_Path {
  public static void main(String[] args) throws IOException {
      Scanner sc = new Scanner(System.in);
      int T = sc.nextInt();
      while (T-- > 0) {
          int n = sc.nextInt();
          int m=sc.nextInt();
          int[][] edge = new int[m][2];
          for(int i=0;i<m;i++){
              edge[i][0]=sc.nextInt();
              edge[i][1]=sc.nextInt();
          }
          int src=sc.nextInt();
          Solution2 obj = new Solution2();
          int res[] = obj.shortestPath(edge,n,m,src);
          for(int i=0;i<n;i++){
              System.out.print(res[i]+" ");
          }
          System.out.println();
      }
  }
}

//} Driver Code Ends

class Pair2 {
	int f;
	int s;

	Pair2(int a, int b) {
		this.f = a;
		this.s = b;
	}
}
class Solution2 {
  
  public int[] shortestPath(int[][] edges,int n,int m ,int src) {
      int[] a =new int[1];
      return a;
  }
}