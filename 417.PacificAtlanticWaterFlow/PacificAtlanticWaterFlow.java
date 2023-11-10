import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution {
    int[][] directions = {{-1,0},{1,0}, {0,-1},{0,1}};

    private boolean[][] dfs(
        int[][] heights,
        ArrayList<int[]> cells
        ){
        
        int m = heights.length;
        int n = heights[0].length; 
        
        boolean[][] reachable = new boolean[m][n];
        boolean[][] visited = new boolean[m][n];
        Stack<int[]> stack = new Stack<>();

        // adding all the cells to the stack
        for (int[] cell: cells){
            int r = cell[0];
            int c = cell[1];

            // adding to stack, marked as visited and is reachable
            stack.add(cell);
            visited[r][c] = true;
            reachable[r][c] = true;
        }

        while (!stack.empty()){
            int[] currCoord = stack.pop();
            int currRow = currCoord[0];
            int currCol = currCoord[1];
            
            for (int[] d: directions){
                int neighborRow = currRow + d[0];
                int neighborCol = currCol + d[1];

                if (
                    (neighborRow >=0 && neighborRow < heights.length) &&
                    (neighborCol >=0 && neighborCol < heights[0].length) &&
                    !visited[neighborRow][neighborCol] &&
                    heights[neighborRow][neighborCol] >= heights[currRow][currCol]
                ){
                    int[] newCoord = {neighborRow, neighborCol};
                    
                    visited[neighborRow][neighborCol] = true;
                    reachable[neighborRow][neighborCol] = true;
                    stack.add(newCoord);
                }
            }

        }
        return reachable;
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        int m = heights.length;
        int n = heights[0].length;
        
        ArrayList<int[]> pacificCells = new ArrayList<>();
        ArrayList<int[]> atlanticCells = new ArrayList<>();
        
        for (int i = 0 ;i < m ;i++){
            int[] pacificCell = {i, 0};
            int[] atlanticCell = {i, n-1};
            pacificCells.add(pacificCell);
            atlanticCells.add(atlanticCell);
        }

        for (int i = 0 ;i < n ;i++){
            int[] pacificCell = {0, i};
            int[] atlanticCell = {m - 1, i};
            pacificCells.add(pacificCell);
            atlanticCells.add(atlanticCell);
        }

        boolean[][] pacificReachable = dfs(heights, pacificCells);
        boolean[][] atlanticReachable  = dfs(heights, atlanticCells);
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n ; j++){
                if (
                    pacificReachable[i][j] &&
                    atlanticReachable[i][j]
                    ){
                        ArrayList<Integer> coord = new ArrayList<>();
                        coord.add(i);
                        coord.add(j);
                        result.add(coord);
                    }
            }
        }
        
        return result;
    }
}

public class PacificAtlanticWaterFlow {
    public static void main(String[] args){
        int[][] heights = {
            {1,2,2,3,5},
            {3,2,3,4,4},
            {2,4,5,3,1},
            {6,7,1,4,5},
            {5,1,1,2,4}
        };
        Solution solution = new Solution();
        List<List<Integer>> result = solution.pacificAtlantic(heights);

        System.out.println(result);
    }
}
