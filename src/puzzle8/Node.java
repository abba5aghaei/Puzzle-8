package puzzle8;

public class Node {

	public Node parent;
	public int[][] matrix;
	public int x, y;
	public int cost;
	public int level;
	
	public int g;
	public int h;

	public Node(int[][] oldMatrix, int oldX, int oldY, int newX, int newY, int level, Node parent) {
		this.parent = parent;
		matrix = new int[3][3];
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				matrix[i][j] = oldMatrix[i][j];

		matrix[oldX][oldY] = matrix[oldX][oldY] + matrix[newX][newY];
		matrix[newX][newY] = matrix[oldX][oldY] - matrix[newX][newY];

		cost = 20;
		this.level = level;
		x = newX;
		y = newY;
	}
}
