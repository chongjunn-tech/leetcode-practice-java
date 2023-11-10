import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0){
            return 0;
        }

        int longestLength = 1;
        // initialize pointer
        int i = 0;
        HashMap<Character, Integer> charToIndex = new HashMap<>();
        
        while (i < s.length() - 1){
            Character c_i = s.charAt(i);
            charToIndex.put(c_i, i);
            for (int j = i + 1; j < s.length(); j++){
                if (charToIndex.containsKey(s.charAt(j))){
                    // set left pointer
                    // jump char if needed 
                    i = charToIndex.get(c_i) + 1;
                    // clear hashmap 
                    charToIndex.clear();
                    break;
                }
                else{
                    charToIndex.put(s.charAt(j),j);
                    longestLength = Math.max(longestLength,charToIndex.size());
                }
            }
        }
        return longestLength;

    }
}

class SolutionHashSet {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0){
            return 0;
        }

        int longestLength = 1;
        // initialize pointer
        int i = 0;
        HashSet<Character> seen = new HashSet<>();
        
        while (i < s.length() - 1){
            Character c_i = s.charAt(i);
            seen.add(c_i);
            for (int j = i + 1; j < s.length(); j++){
                if (seen.contains(s.charAt(j))){
                    seen.clear();
                    break;
                }
                else{
                    seen.add(s.charAt(j));
                    longestLength = Math.max(longestLength, seen.size());
                }
            }
            i++;
        }
        return longestLength;

    }
}
// example 1: abcabcabb
//
public class LongestSubstringWithoutReplacingCharacters {
    public static void main(String[] args){
        SolutionHashSet solution = new SolutionHashSet();
        String s = "pwwkew";
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
