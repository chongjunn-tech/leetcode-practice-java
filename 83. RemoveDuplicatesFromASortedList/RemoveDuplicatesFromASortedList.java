import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode list = head;

        while (list != null){

            if (list.next == null){
                break;
            }
            // keep going back to the same element to check if next is same as list
            // e.g 1 1 1 1-> 1 1 1 -> 1 1 -> 1
            //  list is always the 1st element 
            // so the while loop 'exit' only when next elem is not the same as current 
            if (list.val == list.next.val){
                // remove pointer to next
                list.next = list.next.next;
            }
            else{
                list = list.next;
            }
        }
        return head;
    }
}
public class RemoveDuplicatesFromASortedList {
    public static void main(String[] args){
        ListNode[] listNodes = {
            new ListNode(1),
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

        ListNode newHead = solution.deleteDuplicates(listNodes[0]);
        
        while (newHead!=null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
    
}
