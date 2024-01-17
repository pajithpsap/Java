package Basic_Problems;

/*
 Given a matrix mat of size N x M where every element is either 'O' or 'X'. Replace all 'O' or a group of 'O' with 'X' that are surrounded by 'X'.

A 'O' (or a set of 'O') is considered to be surrounded by 'X' if there are 'X' at locations just below, just above, just left and just right of it.
 */

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Replace_0_x{
  public static void main(String args[])throws IOException
  {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(in.readLine());
      while(t-- > 0){
          String a[] = in.readLine().trim().split(" ");
          int n = Integer.parseInt(a[0]);
          int m = Integer.parseInt(a[1]);
          char mat[][] = new char[n][m];
          for(int i=0; i<n; i++)
          {
              String S[] = in.readLine().trim().split(" ");
              for(int j=0; j<m; j++)
              {
                  mat[i][j] = S[j].charAt(0);
              }
          }
          
          Solution9 ob = new Solution9();
          char[][] ans = ob.fill(n, m, mat);
          for(int i = 0;i < n;i++) {
              for(int j = 0;j < m;j++) {
                  System.out.print(ans[i][j] + " ");
              }
              System.out.println();
          }
      }
  }
}
//} Driver Code Ends


//User function Template for Java

class Solution9{
  
  // dfs
  public static void DFS(int row, int col, int[][] vis, char[][] a, int[] drow, int[] dcol){
      vis[row][col] = 1;
      
      for(int i = 0; i < 4; i++){
          int nrow = row + drow[i];
          int ncol = col + dcol[i];
          
          if(nrow >= 0 && ncol >= 0 && nrow < a.length && ncol < a[0].length 
          && vis[nrow][ncol] == 0 && a[nrow][ncol] == 'O'){
              DFS(nrow, ncol, vis, a, drow, dcol);
          }
      }
      
  }
  static char[][] fill(int n, int m, char a[][])
  {
      int[][] vis = new int[n][m];
      int[] drow = {-1, 0, 1, 0};
      int[] dcol = {0, 1, 0, -1};
      
      
      
      // traversing the 1st and last rows for checking bountys
      
      for(int i = 0; i < m; i++){
          // first row
          if(vis[0][i] == 0 && a[0][i] == 'O'){
              DFS(0, i, vis, a, drow, dcol);
          }
          // last row
          if(vis[n-1][i] == 0 && a[n-1][i] == 'O'){
              DFS(n-1, i, vis, a, drow, dcol);
          }
      }
      
      // traversing the 1st and last columns for checking bountys
      
      for(int j = 0; j < n; j++){
          // first column
          if(vis[j][0] == 0 && a[j][0] == 'O'){
              DFS(j, 0, vis, a, drow, dcol);
          }
          // last column
          if(vis[j][m-1] == 0 && a[j][m-1] == 'O'){
              DFS(j, m-1, vis, a, drow, dcol);
          }
      }
      
      for(int i = 0; i < n; i++){
          for(int j =0; j < m; j++){
              if(vis[i][j] == 0 && a[i][j] == 'O'){
                  a[i][j] = 'X';
              }
          }
      }
      return a;
  }
}