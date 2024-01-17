package Basic_Problems;

import java.util.*;

public class Graph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Graph representation using adjacency list
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the n of nodes ");
		int n = s.nextInt();
		System.out.println("Enter the no of edges");
		int m = s.nextInt();
		// ArrayList for storing the graph
		ArrayList<ArrayList<Integer>> gr = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i <= n; i++) {
			gr.add(new ArrayList<Integer>());
		}
		for (int i = 1; i <= m; i++) {
			int u = s.nextInt();
			int v = s.nextInt();
			
			gr.get(u).add(v);
			gr.get(v).add(u);
		}
		
		//printing the graph
		
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j < gr.get(i).size(); j++) {
				System.out.print(gr.get(i).get(j) + " ");
			}
			System.out.println();
		}
		s.close();

	}

}
