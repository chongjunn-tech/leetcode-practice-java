import java.util.ArrayList;
//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        
        while (head!= null){
            list.add(head.val);
            head = head.next;
        }

        int p1 = 0;
        int p2 = list.size() - 1;

        while (p1 < p2){
            if (list.get(p1)!= list.get(p2)){
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }
}
public class PalindromeLinkedList {
    
    public static void main(String[] args){
    ListNode[] listNodes = {
        new ListNode(1), 
        new ListNode(2), 
        // new ListNode(2),
        // new ListNode(1)
    };
    for (int i = 0; i < listNodes.length - 1; i++){
        listNodes[i].next = listNodes[i+1];
    }
    Solution solution = new Solution();
    System.out.println(solution.isPalindrome(listNodes[0]));
}
}
