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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        // initialize prevNode as null and currNode as the head
        ListNode prevNode = null;
        ListNode currNode = head;
        while (currNode != null){
            ListNode nextNode = currNode.next;
            // reverse link
            currNode.next = prevNode;

            // move forward
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;

    }
}

public class ReverseLinkedList {
    public static void main(String[] args){
        ListNode[] listNodes = {
            new ListNode(1), 
            new ListNode(2), 
            new ListNode(3),
            new ListNode(4),
            new ListNode(5),
        };
        for (int i = 0; i < listNodes.length - 1; i++){
            listNodes[i].next = listNodes[i+1];
        }


        Solution solution = new Solution();
        System.out.println(solution.reverseList(listNodes[0]).next.next.val);
    }
}
