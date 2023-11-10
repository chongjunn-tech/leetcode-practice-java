import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)){
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}
public class ContainsDuplicate{
    public static void main(String[] args){
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        Solution solution = new Solution();
        System.out.println(solution.containsDuplicate(nums));

    }
}