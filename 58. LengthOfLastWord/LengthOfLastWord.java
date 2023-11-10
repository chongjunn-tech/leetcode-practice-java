class Solution {
    public int lengthOfLastWord(String s) {

        int length = 0;
        
        int i = s.length() - 1;
        boolean secondSpace = false;
        
        // reverse loop to find last character
        while (i >= 0 && !secondSpace){

            Character c = s.charAt(i);

            if (c != ' ') length++;

            if (c == ' '  && length > 0){
                secondSpace = true;
            }
            i--;
        }
        return length;
    }
}

public class LengthOfLastWord {
    
    public static void main(String[] args){
        String s ="Hello World";
        Solution solution = new Solution();

        System.out.println(solution.lengthOfLastWord(s));


    }
}
