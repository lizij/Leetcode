package Random_Pick_Index;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {
    Random r;
    int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
        r = new Random();
    }
    
    public int pick(int target) {
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) index.add(i);
        }
        if (index.size() == 0) return -1;
        int res = index.get(0);
        for (int i = 1; i < index.size(); i++) {
            if (r.nextInt(i + 1) == 0) res = index.get(i);
        }
        return res;
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
	public static void main(String[] args) {
		Solution s = new Solution(new int[]{1, 2, 3, 3, 3});
        for (int i = 0; i < 10; i++) {
            StdOut.println(s.pick(3));
        }
    }
}