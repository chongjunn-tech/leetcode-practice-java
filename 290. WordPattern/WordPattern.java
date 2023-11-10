import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> char2String = new HashMap<>();
        HashMap<String, Character> string2Char = new HashMap<>();
        String[] stringArray = s.split(" ");
        
        if (stringArray.length != pattern.length()){
            return false;
        }

        for (int i = 0 ;i < stringArray.length; i++ ){
            Character c = pattern.charAt(i);
            String string = stringArray[i];
              
            String string2 = char2String.getOrDefault(c, null);
            Character c2 = string2Char.getOrDefault(string, null);
            
            if (string2!=null && !string.equals(string2) ||
            (c2!=null && !(c == c2)) ){
                    return false;
                }
            char2String.put(c, string);
            string2Char.put(string,c);
            
        }
        return true;
    }
}
public class WordPattern {
    public static void main(String[] args){
        Solution solution = new Solution();

        String pattern = "abba";
        String s = "dog dog dog dog";

        System.out.println(
            solution.wordPattern(pattern, s)
        );
    }   
}
