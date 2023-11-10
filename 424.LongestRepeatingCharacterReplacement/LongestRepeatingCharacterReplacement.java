import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int characterReplacement(String s, int k) {
        
        int longest = 0;
        HashMap<Character, Integer> chartoCount = new HashMap<>();

        for (int i = 0 ; i < s.length(); i++){
            int len = s.length() - i + 1;
            // break if length is less than longest so far
            if (len < longest)break;

            chartoCount.put(s.charAt(i),1);
            int j = i + 1;

            while ()

        }

        return longest;
    }
}
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args){
        
        Solution solution = new Solution();
        String s = "ABAB"; 
        int  k = 2;
        System.out.println(solution.characterReplacement(s, k));
    }
}


// Example 1:

// Input: s = "ABAB", k = 2
// Output: 4
// Explanation: Replace the two 'A's with two 'B's or vice versa.

// Example 2:
// Input: s = "AABABBA", k = 1
// Output: 4
// Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
// The substring "BBBB" has the longest repeating letters, which is 4.
// There may exists other ways to achieve this answer too.
