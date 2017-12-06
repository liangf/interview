
import java.util.*;




public class Golf {

	class Point {
		int x;
		int y;
		int h;
		Point(int a, int b, int c) {
			this.x = a;
			this.y = b;
			this.h = c;
		}

		public boolean equals(Object obj) {
			if (!(obj instanceof Point)) return false;
			if (obj == this) return true;
			return this.x == ((Point) obj).x  && this.y == ((Point) obj).y;
		}	

		public int hashCode() {
		    return this.x * 31 + this.y;
		}		
	}	

	public int minSteps(int[][] matrix) {
		int step = 0;
		int m = matrix.length;
		int n = matrix[0].length;
		Queue<Point> que = new LinkedList<Point>();
		Set<Point> visited = new HashSet<Point>();

		PriorityQueue<Point> pq = new PriorityQueue<Point>(new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				return p1.h - p2.h;
			}
		});

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] > 1) {
					pq.offer(new Point(i, j, matrix[i][j]));
				}
			}
		}

		que.offer(new Point(0, 0, 1));
		visited.add(new Point(0, 0, 1));
		while (que.size() != 0) {
			step++;		
			int nSize = que.size();
			while (nSize-- > 0) {
				Point p = que.poll();
				int x = p.x, y = p.y;		
				if (x == pq.peek().x && y == pq.peek().y) {
					pq.poll();
					step = step +  matrix[x][y] - 1;
					matrix[x][y] = 1;
					if (pq.size() == 0) return step;
					que.clear();
					visited.clear();
					que.offer(new Point(x, y, 1));
					visited.add(new Point(x, y, 1));
					break;
				} 	
				visited4(matrix, que, visited, pq, x, y);
			}
		}
		return -1;		
	}

	public boolean canVisit(int[][] matrix, Queue<Point> que, Set<Point>visited, PriorityQueue<Point> pq, int x, int y) {
		int m = matrix.length;
		int n = matrix[0].length;
		if (x < 0 || y < 0 || x >= m || y >= n) return false;
		if (matrix[x][y] != 1) {
			if (pq.peek().x == x && pq.peek().y == y) {}
			else return false;
		}
		if (visited.contains(new Point(x, y, 1))) return false;
		
		visited.add(new Point(x, y, 1));
		que.offer(new Point(x, y, 1));
		return true;
	}

	public void visited4(int[][] matrix, Queue<Point> que, Set<Point>visited, PriorityQueue<Point> pq, int x, int y) {	
		canVisit(matrix, que, visited, pq, x, y+1);
		canVisit(matrix, que, visited, pq, x+1, y);
		canVisit(matrix, que, visited, pq, x, y-1);
		canVisit(matrix, que, visited, pq, x-1, y);
	}


	public void test() {
		Set<Point> visited = new HashSet<Point>();
		visited.add(new Point(1, 2, 0));
		System.out.println(visited.contains(new Point(1, 2, 0)));
		System.out.println(visited.contains(new Point(1, 3, 0)));
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] {
			{1, 1, 0, 2},
			{3, 1, 1, 1}
		};

		Golf g = new Golf();
		System.out.println(g.minSteps(matrix));

	}
}