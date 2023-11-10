import java.util.LinkedList;
import java.util.Queue;

class Position{
    public int i;
    public int j;

    public Position(int i, int j){
        this.i = i;
        this.j = j;
    }
}
class Solution {
    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    int maxArea = 0;
    private boolean[][] bfs(int i, int j, int[][] grid, boolean[][] visited){
        Queue<Position> queue = new LinkedList<>();

        // add to queue, mark as visited, area = 1 (count this position)
        queue.add(new Position(i,j));
        visited[i][j] = true;
        int area = 1;
        
        while (!queue.isEmpty()){
            Position pos = queue.poll();

            for (int[] d: directions){
                int row = pos.i + d[0];
                int col = pos.j + d[1];

                if (
                    (row >=0 && row < grid.length) &&
                    (col >=0 && col < grid[0].length) &&
                    !visited[row][col] &&
                    grid[row][col] == 1
                ){
                    // mark as visited
                    visited[row][col] = true;

                    queue.add(new Position(row,col));
                    area++;
                }

            }
        }
        maxArea = Math.max(maxArea, area);

        return visited;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n  = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m ;i++){
            
            for (int j = 0; j < n; j++){

                if (
                    grid[i][j]== 1 &&
                    !visited[i][j]
                ){
                    bfs(i,j,grid,visited);
                }
            }
        }
        return maxArea;
    }
}

public class MaxAreaOfIsland {
    public static void main(String[] args){
        int[][] grid = {
        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        
        int[][] grid2 = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        // {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        // {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        // {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
        // {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
        // {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
        // {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        // {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
    };
        int[][] grid3 = {
        {1}};
        Solution solution = new Solution();
        System.out.println(solution.maxAreaOfIsland(grid3));
    }
}
