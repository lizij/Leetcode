package Max_Chunks_To_Make_Sorted;
public class Solution {
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        /**
         * Find the max in [0...i], if max == i, we know that the previous ones can be a chunk
         * 4ms
         */

        int count = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                count++;
            }
        }
        return count;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.maxChunksToSorted(new int[]{4, 3, 2, 1, 0})); // 1
		System.out.println(s.maxChunksToSorted(new int[]{1, 0, 2, 3, 4})); // 1
	}
}