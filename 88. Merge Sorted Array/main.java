import java.util.Arrays; 


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        

        int[] copiedArray = Arrays.copyOf(nums1, nums1.length);

        int i = 0;
        int j = 0;

        int num1;
        int num2;

        for (int a = 0 ; a < m+n ; a++ ){
            
            if (i >= m){
                nums1[a] = nums2[j];
                j++;
            }
            else if (j >= n){
                nums1[a] = copiedArray[i];
                i++;
            }
            

            else{
                if (nums2[j] < copiedArray[i]){
                    nums1[a] = nums2[j];
                    j++;
                }
                else{
                    nums1[a] = copiedArray[i];
                    i++;
                }
            }

        }
    }
};
public class Main{
    public static void main(String[] args){
        int nums1[] = {4,0,0,0,0,0};
        int m = 1;

        int nums2[] = {1,2,3,5,6};
        int n = 5;
        
        Solution s = new Solution();
        s.merge(nums1,m,nums2,n);

        for (int i = 0 ; i < nums1.length ; i++)
            System.out.println(nums1[i]);

    }

}