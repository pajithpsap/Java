package Basic_Problems;


//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class Flood_fill
{
  public static void main(String[] args) throws IOException
  {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine().trim());
      while(T-->0)
      {
          String[] S1 = br.readLine().trim().split(" ");
          int n = Integer.parseInt(S1[0]);
          int m = Integer.parseInt(S1[1]);
          int[][] image =  new int[n][m];
          for(int i = 0; i < n; i++){
              String[] S2 = br.readLine().trim().split(" ");
              for(int j = 0; j < m; j++)
                  image[i][j] = Integer.parseInt(S2[j]);
          }
          String[] S3 = br.readLine().trim().split(" ");
          int sr = Integer.parseInt(S3[0]);
          int sc = Integer.parseInt(S3[1]);
          int newColor = Integer.parseInt(S3[2]);
          Solution5 obj = new Solution5();
          int[][] ans = obj.floodFill(image, sr, sc, newColor);
          for(int i = 0; i < ans.length; i++){
              for(int j = 0; j < ans[i].length; j++)
                  System.out.print(ans[i][j] + " ");
              System.out.println();
          }
      }
  }
}

//} Driver Code Ends


class Solution5
{
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
  {
      //for storing the answer
      int n = image.length, m = image[0].length;
      int[][] ans = new int[n][m];
      ans = image;
      
      int iniColor = image[sr][sc];
      int[] deltaRow = {-1, 0, 1, 0};
      int[] deltaCol = {0, 1, 0, -1};
      
      dfs(sr, sc, image, ans, newColor, iniColor, deltaRow, deltaCol);
      
      return ans;
      
    
  }
  
   public static void dfs(int sr, int sc, int[][] image, int[][] ans, int newColor, int iniColor, int[] deltaRow, int[] deltaCol){
          
          ans[sr][sc] = newColor;
          int n = image.length, m = image[0].length;
          for(int i = 0; i < 4; i++){
              int nrow = sr + deltaRow[i];
              int ncol = sc + deltaCol[i];
              
              
			if(nrow >= 0 && ncol >= 0 && nrow <= n && ncol >= m &&
              image[nrow][ncol] == iniColor && ans[nrow][ncol] != newColor){
                  dfs(nrow, ncol, image, ans, newColor, iniColor, deltaRow, deltaCol);
              }
          }
          
      }
}