class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

 class Solution {

    public boolean hasCycle(ListNode head) {

        // initalizing fast and slow pointer
        ListNode fast = head, slow = head;

        // check if fast exit loop
        while (fast != null && fast.next != null ){

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }
}

public class LinkedListCycle {

    public static void main(String[] args){
        
        // ListNode[] listNodes = {
        //     new ListNode(3),
        //     new ListNode(2),
        //     new ListNode(0),
        //     new ListNode(4),
        // };
        // for (int i = 0; i < listNodes.length - 1; i++){
        //     listNodes[i].next = listNodes[i+1];
        // }
        // listNodes[3].next = listNodes[1];

        ListNode[] listNodes = {
            new ListNode(1),
            new ListNode(2),
        };
        for (int i = 0; i < listNodes.length - 1; i++){
            listNodes[i].next = listNodes[i+1];
        }
        // listNodes[1].next = listNodes[0];
        Solution solution = new Solution();


        System.out.println(solution.hasCycle(listNodes[0]));
    }
}
