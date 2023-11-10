/**
 * Definition for singly-linked list.
 **/
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            // initalization
            // prehead's next value will be the head
            // at the end just return prehead's next (will throw away prehead)
            ListNode prehead = new ListNode(-1);
            ListNode currNode = prehead;
            ListNode p1 = list1;
            ListNode p2 = list2;

            while (p1 != null && p2 != null){
                if (p1.val < p2.val){
                    // set next node to be lower value
                    currNode.next = p1;
                    // change currNode
                    currNode = p1;
                    // move pointer
                    p1 = p1.next;
                }
                else{
                    currNode.next = p2;
                    currNode = p2;
                    p2 = p2.next;
                }
            }
            if (p1 == null)
                currNode.next = p2;
            else
                currNode.next = p1;

            return prehead.next;
        
        
    
    }
}

public class MergeTwoSortedLists {
    public static void main(String[] args){
         ListNode[] listNodes1 = {
            new ListNode(1), 
            new ListNode(2), 
            new ListNode(4),
        };
        ListNode[] listNodes2 = {
            new ListNode(1), 
            new ListNode(3), 
            new ListNode(4),
        };

        for (int i = 0; i < listNodes1.length - 1; i++){
            listNodes1[i].next = listNodes1[i+1];
        }

        for (int i = 0; i < listNodes2.length - 1; i++){
            listNodes2[i].next = listNodes2[i+1];
        }

        Solution solution = new Solution();
        System.out.println(solution.mergeTwoLists(listNodes1[0],listNodes2[0]).next.next.next.next.val);
    }
}
