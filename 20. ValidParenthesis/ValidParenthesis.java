import java.util.Stack;

class Solution {
    
    String openingParentheses = "({[";
    String closingParentheses = ")}]";

    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();

        
        for (int i = 0; i < s.length(); i++){
            
            Character c = s.charAt(i);

            if (openingParentheses.contains(c.toString())) stack.add(c);

            else{
                if (stack.isEmpty()) return false;
                else{
                    Character stackparenthesis = stack.pop();
                    
                    if (stackparenthesis == '(' && c != ')' ) return false;
                    if (stackparenthesis == '[' && c != ']' ) return false;
                    if (stackparenthesis == '{' && c != '}' ) return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}
public class ValidParenthesis {
    
    public static void main(String[] args){

        String s = "]";
        Solution solution = new Solution();
        System.out.println(solution.isValid(s));

    }
}
