import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Position{
    public int i;
    public int j;
    
    public Position(int i, int j){
        this.i = i;
        this.j = j;
    }
    // Implemented HashCode and equals to use HashSet
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + i;
        hash = 31 * hash + j;
        return hash;
    }

   @Override
    public boolean equals(Object obj){ 
          
    // checking if both the object references are  
    // referring to the same object. 
        if(this == obj) 
            return true; 
          
        // it checks if the argument is of the  
        // type Geek by comparing the classes  
        // of the passed argument and this object. 
        // if(!(obj instanceof Geek)) return false; ---> avoid. 
        if(obj == null || obj.getClass()!= this.getClass()) 
            return false; 
          
        // type casting of the argument.  
        Position rhs = (Position) obj; 
          
        // comparing the state of argument with  
        // the state of 'this' Object. 
        return (rhs.i == this.i && rhs.j == this.j);}
}
class Solution {
    int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private HashSet<Position> bfs(HashSet<Position> visited, Position position, char[][] grid){
        Queue<Position> queue = new LinkedList<>();
        queue.add(position);

        while (!queue.isEmpty()){
            Position pos = queue.poll();

            for (int[] direction: directions){
                int row = pos.i + direction[0];
                int col = pos.j + direction[1];

                Position newPosition = new Position(row, col);

                if (
                    (row >= 0 && row < grid.length) &&
                    (col >= 0 && col < grid[0].length) &&
                    grid[row][col] == '1' &&
                    !visited.contains(newPosition) 
                ){
                    
                    queue.add(newPosition);
                    visited.add(newPosition);
                }
            }

        }
        return visited;
        
    }
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        int n = grid.length;
        int m = grid[0].length;

        HashSet<Position> visited = new HashSet<>();

        for (int i = 0 ; i < grid.length ; i++){
            for (int j = 0; j < grid[0].length; j++){
                char isIsland = grid[i][j];
                Position position = new Position(i,j);

                if (isIsland == '1' &&
                    !visited.contains(position) 
                    ){
                        islandCount++;
                        visited = bfs(visited,position,grid);
                    }                
            }
        }
        return islandCount;
    }
}



// Wrong Solution : Cannot take into account
// 111
// 010
// 111
// class Solution {
//     public int numIslands(char[][] grid) {
//         // this array will store the firstElement in the island
//         // so will keep track if the island has been seen before
//         String[][] firstElementStorage = new String[grid.length][grid[0].length];
//         int islands = 0;

//         for (int i = 0; i < grid.length; i++ ){

//             for (int j = 0; j < grid[i].length ; j++){

//                 // check if is land
//                 if (grid[i][j] == '1'){
//                     // checking vertical
//                     if (i >= 1 && grid[i-1][j] == '1'){
//                         firstElementStorage[i][j] = firstElementStorage[i-1][j];
//                     }

//                     //checking horizontal
//                     if (j >= 1 && grid[i][j-1] == '1'){
//                         firstElementStorage[i][j] = firstElementStorage[i][j-1];
//                     }

//                     // if vertical and horizontal both is null in firstElementStorage
//                     // then it will be the firstElement in the island
//                     if (firstElementStorage[i][j] == null){
//                         firstElementStorage[i][j] = (String.format("%01d",i) + String.format("%01d",j));
//                         islands++;
//                     }

//                 }
//             }
//         }
//         for (int i = 0; i< firstElementStorage.length; i++){
//             System.out.println(Arrays.toString(firstElementStorage[i]));
//         }
//         return islands;
//     }
// }


public class NumberOfIslands {
    public static void main(String[] args){
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };

        char[][] grid2 = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        char[][] grid3 ={
            {'1','1','1'},
            {'0','1','0'},
            {'1','1','1'}
        };
        
        Solution solution = new Solution();

        System.out.println(solution.numIslands(grid));
    }
}
