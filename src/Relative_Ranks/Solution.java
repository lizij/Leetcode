package Relative_Ranks;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        List<Integer> score = Arrays.stream(nums).boxed().collect(Collectors.toList());
        score.sort((o1, o2) -> o2 - o1);
        int N = nums.length;
        String[] res = new String[N];
        for (int i = 0; i < N; i++) {
            int rank = score.indexOf(nums[i]);
            if (rank == 0) res[i] = "Gold Medal";
            else if (rank == 1) res[i] = "Silver Medal";
            else if (rank == 2) res[i] = "Bronze Medal";
            else res[i] = String.valueOf(rank + 1);
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		for (String str: s.findRelativeRanks(new int[]{6, 1, 3, 2, 5})) StdOut.print(str + " ");
	}
}