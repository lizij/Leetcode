package Wiggle_Sort_II;

import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        /**
         * O(nlogn) time and O(n) extra space
         * 121ms
         */
//        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
//        list.sort(Comparator.comparingInt(o -> o));
//        for (int i = nums.length - 1, j = 0, k = i / 2 + 1; i >= 0; i--) {
//            nums[i] = list.get((i & 1) == 0 ? j++ : k++);
//        }

        /**
         * O(n) time and O(1) extra space
         * For example, if nums is {0,1,2,3,4,5,6}, one answer is {6,2,5,1,4,0,3}
         * In a word, split the array into three part:
         * M: the median number of nums
         * S: numbers smaller than or equal to M
         * L: numbers larger than or equal to M
         * The answer is {L,S,L,S,...,L,S,M} or {S,L,S,L,...,S,L,M}
         * index() is to remapping 0~n-1 to 1,3,5,7,...,0,2,4,6,...
         * Without remapping, the for-loop is just to split the array into two parts with M in the middle position, with L in its left side and S in its right side. nums will be {L,L,L,...,L,M,S,...,S,S}
         * With remapping, the position of M will be adjusted to the last index. Before M, L and S will appear one after the other. Then the answer come out.
         * findKthLargestNumber is used to find M with quickselect in O(n) time.
         * 153ms
         */
        int n = nums.length, median = findKthLargestNumber(nums, 0, n - 1, n / 2);
        for (int i = 0, left = 0, right = n - 1; i <= right;) {
            int index = index(i, n);
            if (nums[index] > median) {
                swap(nums, index, index(left, n));
                i++;left++;
            } else if (nums[index] < median) {
                swap(nums, index, index(right, n));
                right--;
            } else i++;
        }
    }

    private int index(int i, int n) {
        return (1 + 2 * i) % (n | 1);
//        return i;
    }

    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    private int findKthLargestNumber(int[] nums, int lo, int hi, int target) {
        if (lo > hi) return -1;
        int pivot = nums[hi];
        int mid = lo;
        for (int i = lo; i < hi; i++) {
            if (nums[i] <= pivot) {
                swap(nums, mid++, i);
            }
        }
        swap(nums, mid, hi);
        if (mid == target) return nums[mid];
        else if (mid < target) return findKthLargestNumber(nums, mid + 1, hi, target);
        else return findKthLargestNumber(nums, lo, mid - 1, target);
    }

    public static void main(String[] args) {
		Solution s = new Solution();
		int[] input = {2,3,6,5,0,4,1};
		int[] input1 = {1,5,1,1,6,4};
		int[] input2 = {1,3,2,2,3,1};
		int[] input3 = {4,5,5,6};
        s.wiggleSort(input1);for (int i: input1) StdOut.print(i + " ");StdOut.println();//1,4,1,5,1,6
        s.wiggleSort(input2);for (int i: input2) StdOut.print(i + " ");StdOut.println();//2,3,1,3,1,2
        s.wiggleSort(input3);for (int i: input3) StdOut.print(i + " ");StdOut.println();//5,6,4,5
	}
}