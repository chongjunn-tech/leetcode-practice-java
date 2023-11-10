import java.util.ArrayList;
import java.util.HashMap;

// hashMap Solution
// class Solution {
//     public boolean isSubsequence(String s, String t) {
//         HashMap<Character,ArrayList<Integer>> charToIndexes = new HashMap<>();

//         for (int i = 0 ; i < t.length();i++ ){
            
//             Character c = t.charAt(i);

//             if (!charToIndexes.containsKey(c)) charToIndexes.put(c, new ArrayList<>());

//             charToIndexes.put(c, charToIndexes.get(c).add(i));
//         }

    

        
//     }
// }
// pointer solution
// two pointer approach
class Solution {
    public boolean isSubsequence(String s, String t) {
        
        //s_p pointer for String s
        //t_p pointer for String t
        int s_p = 0, t_p = 0;

        // if char at s_p  is same as char at t_p: move pointer for s_p
        // move pointer for t_p for all cases
        // exit while loop either s_p has move past its characters or t_p moved past its characters
        while (s_p < s.length()  && t_p < t.length()){

            if (s.charAt(s_p) == t.charAt(t_p)){
                s_p++;
            }
            t_p++;
        }

        // if s_p move past its character means isSubsequence
        return s_p == s.length();

    }
}

public class IsSubsequence {
    public static void main(String[] args){
        String s = "axc", t = "ahbgdc" ;

        Solution solution = new Solution();
        System.out.println(solution.isSubsequence(s, t));

    }
}
