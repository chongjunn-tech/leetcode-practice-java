// import java.util.ArrayList;
// import java.util.HashMap;

// class Solution {
//     // private dfs(int numCourses, HashMap<Integer, ArrayList<Integer>> courseToPrereqs){
        
//     //     boolean[] visited = new boolean[numCourses];

//     //     if ()

//     // }

//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         // act as a Graph adjacency list
//         HashMap<Integer, ArrayList<Integer>> courseToPrereqs = new HashMap<>();
        
//         for (int[] prerequisite: prerequisites){
//             int course = prerequisite[0];
//             int prereq = prerequisite[1];
//             ArrayList<Integer> preReqs = courseToPrereqs.getOrDefault(course, new ArrayList<>());
//             preReqs.add(prereq);
//             courseToPrereqs.put(course, preReqs);
//         }
//         for (Map.Entry<Integer,ArrayList<Integer>> set: courseToPrereqs.entrySet()){

//         }
//         System.out.println(courseToPrereqs);
//         return true;
//     }
// }
// public class CourseSchedule {
//     public static void main(String[] args){
//         Solution solution = new Solution();

//         int numCourses = 2;
//         int[][] prerequisites = {
//             {1,0},
//             {0,1}
//         };
//         System.out.println(solution.canFinish(numCourses, prerequisites));
//     }
// }
// // 
// //
// //
// //


// Example 1:

// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: true
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0. So it is possible.
// Example 2:

// Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
// Output: false
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. 
// So it is impossible.
 