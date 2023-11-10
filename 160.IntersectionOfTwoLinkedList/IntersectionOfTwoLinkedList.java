class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int ctrA = 0, ctrB = 0;
        ListNode pointerA = headA, pointerB = headB;
        // Iteration 1
        // To find number of nodes in each Linked List
        while (pointerA != null && pointerB != null){

            if (pointerA == pointerB) return pointerA;
            pointerA = pointerA.next;
            pointerB = pointerB.next;

            ctrA++;
            ctrB++;
        }
        while (pointerA != null){
            pointerA = pointerA.next;
            ctrA++;
        }
        while (pointerB != null) {
            pointerB = pointerB.next;
            ctrB++;
        }

        // Doing alignment: meaning shift the pointer in the 
        // largest linked list to the same placing as smallest linked list
        pointerA = headA; 
        pointerB = headB;
        // ctrB > ctrA-> more nodes in node B
        // so shift the B pointer more to be in line with A
        if (ctrB > ctrA){
            for (int i = 0 ; i< ctrB - ctrA; i++){
                pointerB = pointerB.next;
            }
        }
        else if (ctrA > ctrB){
            for (int i = 0 ; i < ctrA - ctrB; i++){
                pointerA = pointerA.next;
            } 
        }
        else return null;
        
        // Iteration 2
        // looping through with the aligned pointer to find intersection
        while (pointerA !=null && pointerB != null){
            if (pointerA == pointerB) return pointerA;
            pointerA = pointerA.next;
            pointerB = pointerB.next;
        }


        return null;
    }
}
public class IntersectionOfTwoLinkedList {
    public static void main(String[] args){
        ListNode[] l1 = {
            new ListNode(2), 
            new ListNode(6), 
            new ListNode(4),

        };

        ListNode[] l2 = {
            new ListNode(1), 
            new ListNode(5), 
        };
        for (int i = 0; i < l1.length-1; i++){
            l1[i].next = l1[i+1];
        }

        for (int i = 0; i < l2.length-1; i++){
            l2[i].next = l2[i+1];
        }


        Solution solution = new Solution();
        ListNode head = solution.getIntersectionNode(l1[0], l2[0]);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
