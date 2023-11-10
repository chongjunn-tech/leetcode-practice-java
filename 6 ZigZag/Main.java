import java.util.ArrayList;
import java.lang.Math;

class Solution {
    public String convert(String s, int numRows) {
        ArrayList<ArrayList<Character>> odds = new ArrayList<ArrayList<Character>>();

        int pointer2;
        int next = (numRows + 2);
        for (int i = 0 ;i < s.length() ;i = i + next ){
            System.out.println(i);
            pointer2 = Math.min(i + (numRows - 1),s.length() - 1);
            System.out.println(pointer2);
        }
        return s;
        
    }
}

public class Main{
    public static void main(String args[]){
        Solution solution = new Solution();

        String s = "PAYPALISHIRING";
        int numRows = 4;

        System.out.println(solution.convert(s, numRows));
    }
}