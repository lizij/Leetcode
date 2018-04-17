package Next_Greater_Element_I;


public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int j = 0;
            while(nums1[i] != nums2[j]) j++;
            for (;j < nums2.length; j++) {
                if (nums1[i] < nums2[j]) break;
            }
            if (j == nums2.length) res[i] = -1;
            else res[i] = nums2[j];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] input1 = {{4, 1, 2}, {1, 3, 4, 2}};
        int[][] input2 = {{2, 4}, {1, 2, 3, 4}};
        for (int i: s.nextGreaterElement(input1[0], input1[1])) System.out.print(i + " ");
        System.out.println();
        for (int i: s.nextGreaterElement(input2[0], input2[1])) System.out.print(i + " ");
    }
}
