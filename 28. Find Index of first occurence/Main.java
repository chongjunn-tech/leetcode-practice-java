class Solution{
    public int strStr(String haystack ,String needle){
        int i = 0;
        int j = 0;
        int firstOccur = -1;
        
        while (
            i < haystack.length() &&
            j < needle.length()
        )
        {
            char h = haystack.charAt(i);
            char n = needle.charAt(j);
            if (h == n){
                i++;
                j++;
            }
            else{
                if (j > 0){
                    // go to prev char + 1
                    i = (i - j + 1);
                    j = 0;
                }
                else{
                    i++;
                }

            }
        }

    // exit loop
    if (j == needle.length()){
        firstOccur = i - j;
    }
    
    return firstOccur;
    }
}

public class Main {
    public static void main(String[] args){
    String haystack = "mississippi";
    String needle = "issip";
    Solution solution = new Solution();
    System.out.println(solution.strStr(haystack, needle));

    }}
