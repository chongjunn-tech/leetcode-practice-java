class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode prehead = new ListNode(-1);

        int prevAddVal = 0;
        ListNode previous = prehead;
        
        while (l1 != null && l2 != null){

            int sum = l1.val + l2.val + prevAddVal;
            prevAddVal = sum/10;
            ListNode currNode = new ListNode(sum % 10);
            previous.next = currNode;
            previous = currNode;
        
            l1 = l1.next;
            l2 = l2.next;
        }
        // if l1 not empty
        // still require the similar process as it may also overflow
        if (l1 != null){
            while (l1!=null){
                int sum = l1.val + prevAddVal;
                prevAddVal = sum/10;
                ListNode currNode = new ListNode(sum % 10);
                previous.next = currNode;
                previous = currNode;
                l1 = l1.next;
            }
        }
        else{
            while (l2!=null){
                int sum = l2.val  + prevAddVal;
                prevAddVal = sum/10;
                ListNode currNode = new ListNode(sum % 10);
                previous.next = currNode;
                previous = currNode;
                l2 = l2.next;
            }
            
        }
        // if there is overflow then add a new node
        if (prevAddVal>=1){
            previous.next = new ListNode(prevAddVal);
        }
        return prehead.next;
    }
}
public class AddTwoNumbers {
    public static void main(String[] args){
        ListNode[] l1 = {
            new ListNode(9), 
            new ListNode(9),
            new ListNode(9),
            new ListNode(9),
        };
        ListNode[] l2 = {
            new ListNode(9),
            new ListNode(9),
            new ListNode(9),
            new ListNode(9),
            new ListNode(9),
            new ListNode(9),
            new ListNode(9),
        };  

        for (int i = 0; i < l1.length - 1; i++){
            l1[i].next = l1[i+1];
        }

        for (int i = 0; i < l2.length - 1; i++){
            l2[i].next = l2[i+1];
        }

        Solution solution = new Solution();
        ListNode head = solution.addTwoNumbers(l1[0],l2[0]);


        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
        

    }
}
