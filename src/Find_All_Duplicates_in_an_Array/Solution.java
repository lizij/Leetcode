package Find_All_Duplicates_in_an_Array;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) list.add(nums[i]);
            else set.add(nums[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] input = {4,3,2,7,8,2,3,1};
        for (int i: s.findDuplicates(input)) StdOut.print(i + " ");
    }
}
