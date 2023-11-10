class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //need to maintain 2 pointers
        // fast pointer to find tail
        // slow pointer to point node before nodetobeRemoved
        
        //initialization
        ListNode slow = head;
        ListNode fast = head;
        /// initialize the fast pointer
        for (int i = 0; i < n ;i++)
            fast = fast.next;
        
        // if null then need to remove head
        if (fast == null){
            return head.next;
        }
        else{
            while (fast.next!= null){
                slow = slow.next;
                fast = fast.next;
            }

            // remove node
            slow.next = slow.next.next;

            return head;
    }
    }
}

public class RemoventhNodeFromEndOfList {
    public static void main(String[] args){
        ListNode[] head = {
            new ListNode(1), 
            new ListNode(2),
            // new ListNode(3),
            // new ListNode(4),
            // new ListNode(5),
        };
        int n = 2;
        
        for (int i = 0; i < head.length - 1; i++){
            head[i].next = head[i+1];

        }
        Solution solution = new Solution();

        ListNode newHead  = solution.removeNthFromEnd(head[0], n);


        while (newHead!=null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
}}
