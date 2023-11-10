import java.util.HashMap;
import java.util.Map;
class Solution {
    public boolean isIsomorphic(String s, String t) {
        // constraint t.length == s.length 
        HashMap<Character,Character> tChar2sChar = new HashMap();
        HashMap<Character,Character> sChar2tChar = new HashMap();
        for (int i = 0 ; i < s.length();i++){
            Character sChar = s.charAt(i);
            Character tChar = t.charAt(i);

            Character s2t= sChar2tChar.getOrDefault(sChar,null);
            Character t2s = tChar2sChar.getOrDefault(tChar, null);
            System.out.println("s2t: " + s2t + "t2s:" + t2s);
            if ( 
                (s2t!=null && s2t != tChar) ||
                (t2s!=null && t2s != sChar)
            ){
                return false;
            }

            tChar2sChar.put(tChar,sChar);
            sChar2tChar.put(sChar,tChar);
            
        }
        return true;
    }
    
}

public class IsomorphicStrings {
    public static void main(String args[]){
        String s = "paper";
        String t = "title";

        Solution solution = new Solution();
        System.out.println(solution.isIsomorphic(s, t));
    }    
}
