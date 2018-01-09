package Find_Anagram_Mappings;

import java.util.Arrays;

public class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        if (A == null || B == null || A.length != B.length) {
            return null;
        }
        int[] res = new int[A.length];
        boolean[] visited = new boolean[A.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (!visited[j] && A[i] == B[j]) {
                    visited[j] = true;
                    res[i] = j;
                    break;
                }
            }
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
//		System.out.println(Arrays.toString(s.anagramMappings(new int[]{12, 28, 46, 32, 50}, new int[]{50, 12, 32, 46, 28}))); // [1, 4, 3, 2, 0]
		System.out.println(Arrays.toString(s.anagramMappings(new int[]{21,5,74,5,74,21}, new int[]{21,5,74,74,5,21}))); // [5,4,3,4,3,5]
	}
}