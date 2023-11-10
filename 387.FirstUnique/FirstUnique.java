import java.util.*;
import java.lang.Math;


class Solution{
    public int firstUniqChar(String s){
        HashMap<Character,Integer> uniqchar2lastoccur = new HashMap<>();
        Set<Character> seen = new HashSet<Character>();
        for (int i = s.length() - 1; i >=0; i--){
            char c = s.charAt(i);

            if (seen.contains(c)){
                uniqchar2lastoccur.remove(c);
            }
            else{
                uniqchar2lastoccur.put(c,i);
            }

            seen.add(c);
            
        }
        if (uniqchar2lastoccur.isEmpty()){
            return -1;
        }
        return Collections.min(uniqchar2lastoccur.values());
    }
}

public class FirstUnique {

    public static void main(String[] args){
        Solution s = new Solution();
        String str = "leetcode";
        System.out.println(s.firstUniqChar(str));
    }
}
