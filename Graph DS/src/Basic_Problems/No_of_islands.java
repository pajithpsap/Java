package Basic_Problems;



//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class No_of_islands {
  public static void main(String[] args) throws IOException {
      BufferedReader br =
          new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine().trim());
      while (T-- > 0) {
          String[] s = br.readLine().trim().split(" ");
          int n = Integer.parseInt(s[0]);
          int m = Integer.parseInt(s[1]);
          char[][] grid = new char[n][m];
          for (int i = 0; i < n; i++) {
              String[] S = br.readLine().trim().split(" ");
              for (int j = 0; j < m; j++) {
                  grid[i][j] = S[j].charAt(0);
              }
          }
          Solution4 obj = new Solution4();
          int ans = obj.numIslands(grid);
          System.out.println(ans);
      }
  }
}
//} Driver Code Ends

//Pair class
class Pair{
  int first;
  int second;
  Pair(int n1, int n2){
      this.first = n1;
      this.second = n2;
  }
}
class Solution4 {
  //bfs
  
  public static void bfs(int r, int c, int[][] vis, char[][] grid){
      vis[r][c] = 1;
      int n = grid.length, m = grid[0].length;
      Queue<Pair> q = new LinkedList<Pair>();
      q.add(new Pair(r, c));
      
      while(!q.isEmpty()){
          int row = q.peek().first;
          int col = q.peek().second;
          q.remove();
          
          for(int deltarow = -1; deltarow <= 1; deltarow++){
              for(int deltacol = -1; deltacol <= 1; deltacol++){
                  int nrow = row + deltarow;
                  int ncol = col + deltacol;
                  if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0){
                      vis[nrow][ncol] = 1;
                      q.add(new Pair(nrow, ncol));
                  }
              }
          }
      }
  }

  // Function to find the number of islands.
  public int numIslands(char[][] grid) {
      // Code here
      int n = grid.length, m = grid[0].length;
      int count = 0;
      int[][] vis = new int[n][m];
      
      for(int i = 0; i < n; i++){
          for(int j = 0; j < m; j++){
              if(vis[i][j] == 0 && grid[i][j] == '1'){
                  count++;
                  bfs(i, j, vis, grid);
              }
          }
      }
      return count;
  }
}
