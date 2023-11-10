import java.util.PriorityQueue;

class KthLargest {
  private PriorityQueue<Integer> heap = new PriorityQueue<>();
  private int k;

  public KthLargest(int k, int[] nums) {
    this.k = k;
    for (var n : nums) add(n);
  }
  
  public int add(int val) {
    heap.offer(val);
    if (heap.size() > k) heap.poll();
    return heap.peek();
  }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

public class KthLargestElementinaStream{
    public static void main(String[] args){
        int k = 3;
        int[] nums = {4,5,8,2};
        KthLargest kthlargest = new KthLargest(k, nums);

        int[] addNums = {3,5,10,9,4};
        for (int num: addNums){
            System.out.println(kthlargest.add(num));
        }
    }
}


// Input
// ["KthLargest", "add", "add", "add", "add", "add"]
// [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
// Output
// [null, 4, 5, 5, 8, 8]

// Explanation
// KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
// kthLargest.add(3);   // return 4
// kthLargest.add(5);   // return 5
// kthLargest.add(10);  // return 5
// kthLargest.add(9);   // return 8
// kthLargest.add(4);   // return 8
 