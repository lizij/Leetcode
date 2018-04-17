package Set_Mismatch;



import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int[] res = new int[2];
        int sum = nums.length * (nums.length + 1) / 2;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) res[0] = nums[i];
            else set.add(nums[i]);
            sum -= nums[i];
        }
        res[1] = sum + res[0];
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.findErrorNums(new int[]{3, 2, 3, 4, 6, 5}));
	}
}