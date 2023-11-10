import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length())
            return false;
        
        HashMap<Character,Integer> charactersS = new HashMap<>();
        HashMap<Character, Integer> charactersT = new HashMap<>();
        for (int i = 0;i <s.length() ;i++){
            Character chars = s.charAt(i);
            Character chart = t.charAt(i);
            
            int vals = charactersS.getOrDefault(chars, 0) + 1;
            int valt = charactersT.getOrDefault(chart, 0) + 1;
            charactersS.put(chars,vals);
            charactersT.put(chart,valt);
        }
        
        for (Map.Entry<Character, Integer> entry : charactersS.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            
            // System.out.println(key);
            // System.out.println(charactersT.get(key));
            if (!charactersT.containsKey(key) || 
            charactersT.get(key) != value
            ){
                return false;
            }
        }
        return true;
    }
}
public class ValidAnagrams {
    public static void main(String[] args){
        Solution solution = new Solution();
        String s = "nagaram";
        String t = "anagram";
        System.out.println(solution.isAnagram(s, t));
    }    
}
