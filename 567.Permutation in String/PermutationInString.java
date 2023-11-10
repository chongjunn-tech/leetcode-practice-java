import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> charS1ToCount = new HashMap<>();

        // loop through s1 and store count in hashmap
        for (int i = 0; i < s1.length(); i++){
            Character c1 = s1.charAt(i);
            charS1ToCount.put(c1, charS1ToCount.getOrDefault(c1, 0) + 1);
        }

        // loop through s2
        for (int j = 0; j < s2.length() - s1.length() + 1; j++){
            HashMap<Character,Integer> charS2ToCount = new HashMap<>();
            
            for (int k = j; k < s1.length() + j ; k++){
                Character c2 = s2.charAt(k);
                charS2ToCount.put(c2, charS2ToCount.getOrDefault(c2,0) + 1);
            }
            System.out.println(charS1ToCount);
            System.out.println(charS2ToCount);
            // if 2 hashmap is the same then is equal
            if (charS1ToCount.equals(charS2ToCount)){
                return true;
            }

        }
        return false;
    }
}

class Solution2 {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        
        // array serve as a hashmap since English character has only 26 characters
        int[] charS1ToCount = new int[26];
        int[] charS2ToCount = new int[26];
        // loop through s1.length and store count in the 2 hashmaps
        for (int i = 0; i < s1.length(); i++){

            charS1ToCount[s1.charAt(i) - 'a' ]++;
            charS2ToCount[s2.charAt(i) - 'a' ]++;
        }

        if (Arrays.equals(charS1ToCount, charS2ToCount)){
                return true;
            }
        // loop through s2

        for (int left = 0  ; left < s2.length() - s1.length(); left++){


            // left is to remove, right to add
            int right = left + s1.length();

            // change s2 hashmap
            charS2ToCount[s2.charAt(left) - 'a']--;
            charS2ToCount[s2.charAt(right) - 'a']++;
            
            // use Arrays.equal to compare cannot use .equal
            if (Arrays.equals(charS1ToCount, charS2ToCount)){
                return true;
            }         

        }

        return false;
    }

}
public class PermutationInString {
    public static void main(String[] args){
        Solution2 solution = new Solution2();
        String s1 = "a";
        String s2 = "ab";
        System.out.println(solution.checkInclusion(s1, s2));
    }
}

// Example 1:

// Input: s1 = "ab", s2 = "eidbaooo"
// Output: true
// Explanation: s2 contains one permutation of s1 ("ba").
// Example 2:

// Input: s1 = "ab", s2 = "eidboaoo"
// Output: false
