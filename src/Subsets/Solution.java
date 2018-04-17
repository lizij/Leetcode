package Subsets;



import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] marked = new boolean[nums.length];
        generate(nums, nums.length - 1, marked, res);
        return res;
    }

    private void generate(int[] nums, int pos, boolean[] marked, List<List<Integer>> res){
        if (pos < 0){
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < marked.length; i++) {
                if (marked[i]) list.add(nums[i]);
            }
            res.add(list);
            return;
        }
        marked[pos] = true;
        generate(nums, pos - 1, marked, res);
        marked[pos] = false;
        generate(nums, pos - 1, marked, res);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		List<List<Integer>> output1 = s.subsets(new int[]{1, 2, 3});
		for (List<Integer> list: output1){
		    System.out.print("#");
		    for (int i: list) System.out.print(i + " ");
		    System.out.println();
        }
	}
}