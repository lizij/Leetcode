package Number_of_Subarrays_with_Bounded_Maximum;
public class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        if (A == null || A.length == 0 || L > R) {
            return 0;
        }

        /**
         * If A[i] in [L, R], we count all number in [head, i]
         * If A[i] < L, we count all number in from head to the last number in [L, R]
         * If A[i] > R, reset head and count
         * 10ms
         */

        int res = 0, count = 0, head = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= L && A[i] <= R) {
                res += i - head + 1;
                count = i - head + 1;
            } else if (A[i] < L) {
                res += count;
            } else {
                head = i + 1;
                count = 0;
            }
        }

        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.numSubarrayBoundedMax(new int[]{2,1,4,3}, 2, 3)); // 3
	}
}