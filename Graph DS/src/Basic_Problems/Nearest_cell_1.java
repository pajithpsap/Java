package Basic_Problems;



//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class Nearest_cell_1
{
  public static void main(String[] args) throws IOException
  {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine().trim());
      while(T-->0)
      {
          String[] s = br.readLine().trim().split(" ");
          int n = Integer.parseInt(s[0]);
          int m = Integer.parseInt(s[1]);
          int[][] grid = new int[n][m];
          for(int i = 0; i < n; i++){
              String[] S = br.readLine().trim().split(" ");
              for(int j = 0; j < m; j++){
                  grid[i][j] = Integer.parseInt(S[j]);
              }
          }
          Solution8 obj = new Solution8();
          int[][] ans = obj.nearest(grid);
          for(int i = 0; i < ans.length; i++){
              for(int j = 0; j < ans[i].length; j++){
                  System.out.print(ans[i][j] + " ");
              }
              System.out.println();
          }
      }
  }
}
//} Driver Code Ends

class Pair8{
  int fi;
  int se;
  int steps;
  
  Pair8(int n1, int n2, int n3){
      this.fi = n1;
      this.se = n2;
      this.steps = n3;
  }
}

class Solution8
{
  //Function to find distance of nearest 1 in the grid for each cell.
  public int[][] nearest(int[][] grid)
  {
      int n = grid.length, m = grid[0].length;
      int[][] vis = new int[n][m];
      int[][] dis = new int[n][m];
      Queue<Pair8> q = new LinkedList<Pair8>();
      
      for(int i = 0; i < n; i++){
          for(int j = 0; j < m; j++){
              if(grid[i][j] == 1){
                  q.add(new Pair8(i, j, 0));
                  vis[i][j] = 1;
              }
          }
      }
      
      int[] drow = {-1, 0, 1, 0};
      int[] dcol = {0, 1, 0, -1};
      
      while(!q.isEmpty()){
          int row = q.peek().fi;
          int col = q.peek().se;
          int st = q.peek().steps;
          q.remove();
          
          dis[row][col] = st;
          
          for(int i = 0; i < 4; i++){
              int nrow = row + drow[i];
              int ncol = col + dcol[i];
              
              if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m 
              && vis[nrow][ncol] == 0){
                  vis[nrow][ncol] = 1;
                  q.add(new Pair8(nrow, ncol, st + 1));
              }
          }
      }
      return dis;
      
  }
}