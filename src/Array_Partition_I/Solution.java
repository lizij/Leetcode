package Array_Partition_I;

import edu.princeton.cs.algs4.StdOut;

public class Solution {

    public int arrayPairSum(int[] nums) {
        int sum = 0;
        sort(nums);
        for (int i = 0; i < nums.length; i+=2) {
            sum += Math.min(nums[i], nums[i + 1]);
        }
        return sum;
    }

    private void sort(int[] nums){
        QuickSort(nums, 0, nums.length - 1);
    }

    private void QuickSort(int[] nums, int lo, int hi){
        if (hi <= lo) return;
        int p = partition(nums, lo, hi);
        QuickSort(nums, lo, p - 1);
        QuickSort(nums, p + 1, hi);
    }

    private int partition(int[] nums, int lo, int hi){
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (i <= j){
            while(nums[++i] < v) if (i == hi) break;
            while(nums[--j] > v) if (j == lo) break;
            if (i >= j) break;
            exch(nums, i, j);
        }
        exch(nums, lo, j);
        return j;
    }

    private void exch(int[] nums, int a, int b){
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }

    public static void main(String[] args) {
        int[] input = {1, 4, 3, 2};
        Solution s = new Solution();
        StdOut.println(s.arrayPairSum(input));
    }
}
