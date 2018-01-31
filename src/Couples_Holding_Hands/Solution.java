package Couples_Holding_Hands;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minSwapsCouples(int[] row) {
        if (row == null || row.length == 0 || (row.length & 1) == 1) {
            return 0;
        }

        /**
         * Greedy solution:
         * for every i (even), try to arrange row[i] and the other by 1 swap
         * 7ms
         */

        Map<Integer, Integer> indexes = new HashMap<>();
        for (int i = 0; i < row.length; i++) {
            indexes.put(row[i], i);
        }

        int res = 0;
        for (int i = 0; i < row.length; i += 2) {
            int other = (row[i] & 1) == 0 ? row[i] + 1 : row[i] - 1;
            int j = indexes.get(other);
            if (j != i + 1) {
                int tmp = row[i + 1];
                row[i + 1] = row[j];
                row[j] = tmp;
                indexes.put(row[i + 1], i + 1);
                indexes.put(row[j], j);
                res++;
            }
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.minSwapsCouples(new int[]{0, 2, 1, 3})); // 1
		System.out.println(s.minSwapsCouples(new int[]{3, 2, 0, 1})); // 0
	}
}