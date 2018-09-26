package puzzle8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Puzzle {

	int[] row = { 1, 0, -1, 0 };
	int[] col = { 0, -1, 0, 1 };
	long ns = 0L;
	int counter;
	int searchCost;
	String route;
	
	public void solve_BFS(int[][] initial, int[][] goal, int x, int y) {
		counter = 0;																																ns = 0L;
		Queue<Node> queue = new LinkedList<Node>();																									ns++;
		Node root = new Node(initial, x, y, x, y, 0, null);																							ns++;
		root.cost = calculateCost(initial, goal);																									ns++;
		queue.add(root);																															ns++;
		while (!queue.isEmpty()) {																													ns++;
			Node node = queue.remove();																												ns++;
			if (node.cost == 0) {																													ns++;
				printPath(node);																													ns++;
				return;
				}
			counter++;																																ns++;
			for (int i = 0; i < 4; i++) {																											ns++;
				if (isSafe(node.x + row[i], node.y + col[i])) {																						ns++;
					Node child = new Node(node.matrix, node.x, node.y, node.x + row[i], node.y + col[i], node.level + 1, node);						ns++;
					child.cost = calculateCost(child.matrix, goal);																					ns++;
					queue.add(child);																												ns++;
				}
			}
		}
	}

	public void solve_IDFS(int[][] initial, int[][] goal, int x, int y) {
		counter = 0;																																ns = 0L;
		int limit = 1;																																ns++;
		Stack<Node> stack = new Stack<Node>();																										ns++;
		while(true) {																																ns++;
			Node root = new Node(initial, x, y, x, y, 0, null);																						ns++;
			root.cost = calculateCost(initial, goal);																								ns++;
			stack.push(root);																														ns++;
			limit++;																																ns++;
			while (!stack.isEmpty()) {																												ns++;
				Node node = stack.pop();																											ns++;
				if (node.cost == 0) {																												ns++;
					printPath(node);																												ns++;
					return;
					}
				if(node.level < limit) {																											ns++;
					counter++;																														ns++;
					for (int i = 0; i < 4; i++) {																									ns++;
						if (isSafe(node.x + row[i], node.y + col[i])) {																				ns++;
							Node child = new Node(node.matrix, node.x, node.y, node.x + row[i], node.y + col[i], node.level + 1, node);				ns++;
							child.cost = calculateCost(child.matrix, goal);																			ns++;
							stack.push(child);																										ns++;
						}
					}
				}
			}
		}
	}
	
	public void solve_UCS(int[][] initial, int[][] goal, int x, int y) {
		counter = 0;																																ns = 0L;
		PriorityQueue<Node> queue = new PriorityQueue<Node>(1000, (a, b) -> (a.cost) - (b.cost));													ns++;
		Node root = new Node(initial, x, y, x, y, 0, null);																							ns++;
		root.cost = calculateCost(initial, goal);																									ns++;
		queue.add(root);																															ns++;
		while (!queue.isEmpty()) {																													ns++;
			Node node = queue.poll();																												ns++;
			if (node.cost == 0) {																													ns++;
				printPath(node);																													ns++;
				return;
				}
			counter++;																																ns++;
			for (int i = 0; i < 4; i++) {																											ns++;
				if (isSafe(node.x + row[i], node.y + col[i])) {																						ns++;
					Node child = new Node(node.matrix, node.x, node.y, node.x + row[i], node.y + col[i], node.level + 1, node);						ns++;
					child.cost = calculateCost(child.matrix, goal);																					ns++;
					queue.add(child);																												ns++;
				}
			}
		}
	}
	
	public void solve_AStar(int[][] initial, int[][] goal, int x, int y) {
		counter = 0;																																ns = 0L;
		PriorityQueue<Node> queue = new PriorityQueue<Node>(1000, (a, b) -> (a.g + a.h) - (b.g + b.h));												ns++;	
		Node root = new Node(initial, x, y, x, y, 0, null);																							ns++;
	    root.g = 0;																																	ns++;
	    root.h = hiurestic(initial, goal);																											ns++;
		root.cost = calculateCost(initial, goal);																									ns++;
	    queue.add(root);																															ns++;

	    while (!queue.isEmpty()) {																													ns++;
	      Node node = queue.poll();																													ns++;
	      if (node.cost == 0) {																														ns++;
			printPath(node);																														ns++;
			return;
			}
	      
	      counter++;																																ns++;
	      for (int i = 0; i < 4; i++) {																												ns++;
			if (isSafe(node.x + row[i], node.y + col[i])) {																							ns++;
				Node child = new Node(node.matrix, node.x, node.y, node.x + row[i], node.y + col[i], node.level + 1, node);							ns++;
				child.cost = calculateCost(child.matrix, goal);																						ns++;
				child.h = hiurestic(child.matrix, goal);																							ns++;
				child.g = node.g + 1;																												ns++;
		        queue.add(child);																													ns++;
		        	}
			}
	  }
	}
	
	public void solve_IDA(int[][] initial, int[][] goal, int x, int y) {
		counter = 0;																																			ns = 0L;
		int limit = 1;																																			ns++;
		PriorityQueue<Node> queue = new PriorityQueue<Node>(1000, (a, b) -> (a.g + a.h) - (b.g + b.h));															ns++;
		while(true) {
			Node root = new Node(initial, x, y, x, y, 0, null);																									ns++;
		    root.g = 0;																																			ns++;
		    root.h = hiurestic(initial, goal);																													ns++;
			root.cost = calculateCost(initial, goal);																											ns++;
		    queue.add(root);																																	ns++;
		    limit++;																																			ns++;
		    while (!queue.isEmpty()) {																															ns++;
			      Node node = queue.poll();																														ns++;
			      if (node.cost == 0) {																															ns++;
					printPath(node);																															ns++;
					return;
					}
			      if(node.g + node.h < limit) {																													ns++;
				      counter++;																																ns++;
				      for (int i = 0; i < 4; i++) {																												ns++;
						if (isSafe(node.x + row[i], node.y + col[i])) {																							ns++;
							Node child = new Node(node.matrix, node.x, node.y, node.x + row[i], node.y + col[i], node.level + 1, node);							ns++;
							child.cost = calculateCost(child.matrix, goal);																						ns++;
							child.h = hiurestic(child.matrix, goal);																							ns++;
							child.g = node.g + 1;																												ns++;
					        queue.add(child);																													ns++;
						}																																		ns++;
					}
				  }
			 }
		}
	}
	
	public void solve_firstGreedy(int[][] initial, int[][] goal, int x, int y) {
		counter = 0;																																ns = 0L;
		PriorityQueue<Node> queue = new PriorityQueue<Node>(1000, (a, b) -> (a.h) - (b.h));															ns++;	
		Node root = new Node(initial, x, y, x, y, 0, null);																							ns++;
	    root.h = hiurestic(initial, goal);																											ns++;
		root.cost = calculateCost(initial, goal);																									ns++;
	    queue.add(root);																															ns++;

	    while (!queue.isEmpty()) {																													ns++;
	      Node node = queue.poll();																													ns++;
	      if (node.cost == 0) {																														ns++;
			printPath(node);																														ns++;
			return;
			}
	      
	      counter++;																																ns++;
	      for (int i = 0; i < 4; i++) {																												ns++;
			if (isSafe(node.x + row[i], node.y + col[i])) {																							ns++;
				Node child = new Node(node.matrix, node.x, node.y, node.x + row[i], node.y + col[i], node.level + 1, node);							ns++;
				child.cost = calculateCost(child.matrix, goal);																						ns++;
				child.h = hiurestic(child.matrix, goal);																							ns++;
		        queue.add(child);																													ns++;
		        	}
			}
	  }
	}

	public int hiurestic(int[][] initial, int[][] goal) {
		int h = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (initial[i][j] != 0 && initial[i][j] != goal[i][j]) {
					h += distance(i,j,initial[i][j],goal);
				}
			}
		}
		return h;
	}

	private int distance(int i, int j, int k, int[][] goal) {
		for (int ig = 0; ig < 3; ig++) {
			for (int jg = 0; jg < 3; jg++) {
				if(goal[ig][jg] == k)
					return Math.abs(i-ig)+Math.abs(j-jg);
			}
		}
		return 0;
	}

	public int calculateCost(int[][] initial, int[][] goal) {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (initial[i][j] != 0 && initial[i][j] != goal[i][j]) {
					count++;
				}
			}
		}
		return count;
	}

	public boolean isSafe(int x, int y) {
		return (x >= 0 && x < 3 && y >= 0 && y < 3);
	}
	
	public void printPath(Node node) {
		String output = "";
		route = "";
		searchCost = 0;
		printConsole(node);
		output += "Runtime = "+ns+" ns \n";
		output +="Search Cost = "+(searchCost-1)+"\n";
		output +="Expanded Nodes = "+(counter)+"\n";
		output += "Route:\n";
		output += route;
		output += "________________________________________________________________________\n";
		Frame.print(output);
		printMap(node);
	}

	private void printConsole(Node node) {
		if (node != null) {
			printConsole(node.parent);
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++)
					route += node.matrix[i][j] + "  ";
				route +="\n";
			}
			searchCost++;
			route +="\n";
		}
	}

	private void printMap(Node node) {
		if (node != null) {
			printMap(node.parent);
			
			Frame.map = node.matrix;
			Frame.panel.repaint();
			
			try {
				Thread.sleep(500);
			}
			catch (InterruptedException e) {}
		}
	}

	public boolean isSolvable(int[][] matrix) {
		int count = 0;
		List<Integer> array = new ArrayList<Integer>();
		
		array.add(matrix[0][0]);
		array.add(matrix[0][1]);
		array.add(matrix[0][2]);
		array.add(matrix[1][2]); //     1  2  3
		array.add(matrix[2][2]); //  => 8  0  4
		array.add(matrix[2][1]); //     7  6  5
		array.add(matrix[2][0]);
		array.add(matrix[1][0]);
		array.add(matrix[1][1]);

		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (array.get(i) != 0 && array.get(j) != 0 && array.get(i) > array.get(j)) {
					count++;
				}
			}
		}
		return (count % 2 == 0);
	}
}