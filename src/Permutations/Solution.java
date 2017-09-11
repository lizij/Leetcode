package Permutations;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        generate(null, nums, res);
        return res;
    }

    private void generate(ArrayList<Integer> list, int[] nums, List<List<Integer>> res){
        if (list == null){
            list = new ArrayList<>();
        }
        if (list.size() == nums.length){
            res.add((ArrayList)list.clone());
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            generate(list, nums, res);
            list.remove((Integer) nums[i]);
        }
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		List<List<Integer>> output1 = s.permute(new int[]{1, 2, 3});
		for (List<Integer> list: output1){
		    for (Integer i: list){
                StdOut.print(i + " ");
            }
            StdOut.println();
        }
	}
}