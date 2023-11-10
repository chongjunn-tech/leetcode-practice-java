class Solution1 {
    public String reverseVowels(String s) {
        String VOWELS = "aeiouAEIOU";
        
        char[] reverseVowel = s.toCharArray();
        if (s.length() == 1 ){
            return s;
        }
        int p1 = 0;
        int p2 = s.length() - 1;

        while ( p1 < p2 ){
            char char1 = s.charAt(p1);
            char char2 = s.charAt(p2);
            if (
                VOWELS.indexOf(char1) != -1 &&
                VOWELS.indexOf(char2) != -1
            ){
                //switch
                char tmp = reverseVowel[p2];
                reverseVowel[p2] = reverseVowel[p1];
                reverseVowel[p1] = tmp;
                p1++;
                p2--;
            }
            else if (
                VOWELS.indexOf(char1) != -1
            ){
                p2--;
            }
            else if (VOWELS.indexOf(char2) != -1){
                 p1++;
            }
            else{
                p1++;
                p2--;
            }
            
        }
        return new String(reverseVowel);
    }
}

class Solution2 {
    public String reverseVowels(String s) {
        String VOWELS = "aeiouAEIOU";

        char [] reverseVowel = s.toCharArray();

        int p1 = 0;
        int p2 = s.length() - 1;

        while (p1 < p2){
            char c1 = reverseVowel[p1];
            char c2 = reverseVowel[p2];
            
            // 1st condition p1<p2
            // will ensure that will exit loop when p1 and p2 hits the middle
            while (p1 < p2 && VOWELS.indexOf(c1) == -1){
                p1++;
                c1 = reverseVowel[p1];
            }
            while (p1 < p2 && VOWELS.indexOf(c2) == -1){
                p2--;
                c2 = reverseVowel[p2];
            }
   
            //switch
            System.out.println(p1 + "->" + p2);;
            reverseVowel[p2] = c1;
            reverseVowel[p1] = c2;
            p1++;
            p2--;

        }
        return new String(reverseVowel);

    }
}
public class Main {
    public static void main(String[] args){
        Solution1 s = new Solution1();
        System.out.println(s.reverseVowels("leetcode"));

        Solution2 s2 = new Solution2();
        System.out.println(s2.reverseVowels("leetcode"));

  }  
}
