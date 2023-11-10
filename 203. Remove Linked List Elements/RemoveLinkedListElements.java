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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }
        if (head.next == null){
            if (head.val == val){
                return null;
            }
            else{
                return head;
            }
        }
        ListNode prevNode = new ListNode(-1);
        ListNode currNode = head;
        ListNode nextNode = head.next;
        
        while (nextNode!= null){
            if (currNode.val == val){
                
                // assign head to the next value if currNode is head
                if (currNode == head){
                    head = currNode.next;
                }
                // remove currNode
                prevNode.next = nextNode;
            }
            else{
                prevNode = currNode;
            }
            currNode = nextNode;
            nextNode = nextNode.next;
            
        }
        // while loop exit if nextNode is null (so have not checked lastnode)
        // check if lastnode is val
        if (currNode.val == val){
            if (currNode == head){
                head = currNode.next;
            }
            prevNode.next = null;
        }
        
        return head;
    }
}



public class RemoveLinkedListElements {
    public static void main(String[] args){
        ListNode[] listNodes = {
            new ListNode(1), 
            new ListNode(1), 
            // new ListNode(7),
            // new ListNode(7),
            // new ListNode(7),
            // new ListNode(7),
            // new ListNode(7),
        };
        for (int i = 0; i < listNodes.length - 1; i++){
            listNodes[i].next = listNodes[i+1];
        }

        Solution solution = new Solution();
        System.out.println(solution.removeElements(listNodes[0],2).next);
    }
}
