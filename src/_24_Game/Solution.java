package _24_Game;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    boolean res;
    double errors = 0.001;
    public boolean judgePoint24(int[] nums) {
        res = false;
        List<Double> list = new ArrayList<>();
        for (int n: nums) list.add((double) n);
        helper(list);
        return res;
    }

    private void helper(List<Double> nums) {
        if (res) return;
        if (nums.size() == 1) {
            res =  Math.abs(nums.get(0) - 24.0) < errors;
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < i; j++) {
                double n1 = nums.get(i), n2 = nums.get(j);
                List<Double> calcResult = new ArrayList(Arrays.asList(n1 + n2, n1 - n2, n2 - n1, n1 * n2));//store all possible calculate result with nums[i] and nums[j]
                if (Math.abs(n1) > errors) calcResult.add(n2 / n1);
                if (Math.abs(n2) > errors) calcResult.add(n1 / n2);
                nums.remove(i);
                nums.remove(j);//remove i and j
                for (double n: calcResult) {
                    nums.add(n);
                    helper(nums);
                    nums.remove(nums.size() - 1);
                }
                nums.add(j, n2);//restore i and j
                nums.add(i, n1);
            }
        }
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.judgePoint24(new int[]{4, 1, 8, 7}));//true
        System.out.println(s.judgePoint24(new int[]{1, 2, 1, 2}));//false
	}
}