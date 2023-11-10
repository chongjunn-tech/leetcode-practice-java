class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right){
            // if not alphanumeric e.g space or punctuations, move pointers
            while ( left <right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while ( left< right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            
            Character leftC = Character.toLowerCase(s.charAt(left));
            Character rightC = Character.toLowerCase(s.charAt(right));

            if (leftC !=rightC){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

public class ValidPalindrome {
    public static void main(String[] args){
        Solution s = new Solution();
        String str = ".," ; 
        System.out.println(s.isPalindrome(str));
    }
}
