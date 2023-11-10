import java.util.ArrayList;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        

        String firstString = strs[0];
        for (int i = 0; i < firstString.length(); i++ ){
            Character c = firstString.charAt(i);
            
            for (int j = 1; j < strs.length ;j++){
                
                String nextString = strs[j];
                
                // checks:
                // - string length is lesser than i
                // - character does not matches
                if (nextString.length() - 1 < i || nextString.charAt(i) != c){
                    return firstString.substring(0,i);
                }
                
            }
        }
        return firstString.substring(0,firstString.length());
    }
}

public class LongestCommonPrefix {
    public static void main(String[] args){
        String[] strs = {"ab","a"};

        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(strs));

    }
}
