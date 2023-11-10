import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public void reorderList(ListNode head) {
        ArrayList<ListNode> listNodes = new ArrayList<>();
        while (head != null){
            listNodes.add(head);
            head = head.next;        
        }

        int left = 0;
        int right = listNodes.size() - 1;

        while (left < right){
            listNodes.get(left).next = listNodes.get(right);
            left++;
            listNodes.get(right).next =  listNodes.get(left);
            right--;
        }
        // setting the faster pointer as null to prevent a cycle
        listNodes.get(left).next = null;
    
    }
}

public class ReorderList {
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
        solution.reorderList(listNodes[0]);
        ListNode head = listNodes[0];
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
        

    }
}
