import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode middleNode(ListNode head) {

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

public class MiddleofLinkedList {
    public static void main (String[] args){
    ListNode[] listNodes = {
            new ListNode(1), 
            new ListNode(2), 
            new ListNode(3),
            new ListNode(4),
            new ListNode(5),
            new ListNode(6),
        };

    for (int i = 0; i < listNodes.length - 1; i++){
            listNodes[i].next = listNodes[i+1];
    }

    Solution solution = new Solution();

    ListNode head = solution.middleNode(listNodes[0]);

    while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
}
}
