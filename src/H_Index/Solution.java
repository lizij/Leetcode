package H_Index;

import java.util.Arrays;
public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        /**
         * Binary Search solution: find the last number satisfying citations[i] >= citations.length - i
         * 13ms
         */
        Arrays.sort(citations);
        int lo = 0, hi = citations.length - 1, n = citations.length;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (citations[mid] == n - mid) {
                return n - mid;
            } else if (citations[mid] < n - mid) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return n - lo;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
	}
}