import java.util.Stack;

class MinStack {
    int min;
    Stack<Integer> stack; 

    public MinStack() {
        this.min = Integer.MAX_VALUE;
        this.stack = new Stack<>();
    }
    
    public void push(int val) {
        if (val <=min){
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        
    }
    
    public int top() {
        
    }
    
    public int getMin() {
        
    }
}
public class MinStack {
    public static void main(String[] args){
        MinStack obj = new MinStack();
        int[] vals = {-2,0,-3};
        for (int val: vals){
            obj.push(val);
        }
        System.out.println(obj.getMin());
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();

        System.out.println(param_3);
        System.out.println(param_4);
    }
}
