import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>,List<String>> hashMaptoAnagrams = new HashMap<>();
        List<List<String>> anagrams = new ArrayList<>();
        for (String str: strs){
            HashMap<Character, Integer>  hashMap = stringToHashMap(str);
            if (!hashMaptoAnagrams.containsKey(hashMap)){
                List<String> list = new ArrayList<>();
                list.add(str);
                hashMaptoAnagrams.put(hashMap, list);
            }
            else{
                List<String> newList = hashMaptoAnagrams.get(hashMap);
                newList.add(str);
                hashMaptoAnagrams.put(hashMap,newList);
            }
        }
       
        for (List<String> value: hashMaptoAnagrams.values()){
            anagrams.add(value);
        }
        return anagrams;

    }
    private HashMap<Character, Integer> stringToHashMap(String str){
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < str.length(); i++){
            Character c = str.charAt(i);
            if (!hashMap.containsKey(c)){
                hashMap.put(c,0);
            }
            hashMap.put(c,hashMap.get(c)+1);

        }
        return hashMap;
    }
}

public class GroupAnagrams {
    public static void main(String[] args){
        String[] strs = {"a"};
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(strs));
    }   
}
