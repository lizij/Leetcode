package Median_of_Two_Sorted_Arrays;
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length + nums2.length == 0) {
            return 0;
        }

        /**
         * Similar with merge() in MergeSort
         * 72ms
         */
        int p1 = 0, p2 = 0, cur = 0, m = nums1.length, n = nums2.length;
        int[] aux = new int[m + n];

        while (p1 < m && p2 < n) {
            aux[cur++] = nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
        }

        while (p1 < m) {
            aux[cur++] = nums1[p1++];
        }

        while (p2 < n) {
            aux[cur++] = nums2[p2++];
        }

        return ((m + n) & 1) == 0 ? (aux[(m + n) / 2] + aux[(m + n) / 2 - 1]) / 2.0 : aux[(m + n) / 2];
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.findMedianSortedArrays(new int[]{1, 3}, new int[]{2})); // 2.0
		System.out.println(s.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4})); // 2.5
	}
}