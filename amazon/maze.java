import java.util.*;

public class Maze {

	private static boolean canVisit(int x, int y, boolean[][] visited, int[][] maze) {
		int m = visited.length;
		int n = visited[0].length;
		if (x>=0 && x<m && y>=0 && y<n && !visited[x][y] && maze[x][y] == 1) {
			return true;
		}
		return false;
	}

	public static int minStep(int[][] maze, int[] src, int[] dst) {
		int m = maze.length;
		int n = maze[0].length;
		boolean[][] visited = new boolean[m][n];
		Queue<int[]> que = new LinkedList<int[]>();

		visited[src[0]][src[1]] = true;
		que.add(new int[]{src[0],src[1], 0});

		while ( !que.isEmpty() ) {
			int x = que.peek()[0];
			int y = que.peek()[1];
			int dist = que.peek()[2];
			if (x == dst[0] && y == dst[1]) {
				return dist;
			}
			System.out.println(x + "," + y + ":" + dist);
			// right
			if ( canVisit(x, y+1, visited, maze) ) {
				System.out.println("right");
				visited[x][y+1] = true;
				que.add(new int[]{x, y+1, dist+1});
			}
			// down
			if ( canVisit(x+1, y, visited, maze) ) {
				System.out.println("down");
				visited[x+1][y] = true;
				que.add(new int[]{x+1, y, dist+1});
			}
			// left
			if ( canVisit(x, y-1, visited, maze) ) {
				System.out.println("left");
				visited[x][y-1] = true;
				que.add(new int[]{x, y-1, dist+1});
			}	
			// top
			if ( canVisit(x-1, y, visited, maze) ) {
				System.out.println("top");
				visited[x-1][y] = true;
				que.add(new int[]{x-1, y, dist+1});
			}							
			que.poll();
		}
		return -1;
	}

	public static void main(String[] args) {

		System.out.println("hello");
		int[][] maze = new int[][]{
			{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
        	{1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
       		{1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
        	{0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
        	{1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
        	{1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
        	{1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
        	{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
        	{1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }
        };
        int[] src = new int[]{0, 0};
        int[] dst = new int[]{3, 4};
		System.out.println(minStep(maze, src, dst));
	}
}
