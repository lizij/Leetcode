package _4Sum_II;



import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int N = A.length;
        if (N == 0) return 0;
        HashMap<Integer, Integer> ab = new HashMap<>();
        HashMap<Integer, Integer> cd = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ab.put(A[i] + B[j], ab.getOrDefault(A[i] + B[j], 0) + 1);
                cd.put(C[i] + D[j], cd.getOrDefault(C[i] + D[j], 0) + 1);
            }
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry: ab.entrySet()){
            Integer value = entry.getKey();
            count += entry.getValue() * cd .getOrDefault(0 - value, 0);
        }
        return count;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.fourSumCount(new int[]{1, 2}, new int[]{-1, -2}, new int[]{-1, 2}, new int[]{0, 2}));
	}
}