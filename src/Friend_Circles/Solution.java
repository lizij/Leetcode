package Friend_Circles;



import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Solution {
    public int findCircleNum(int[][] M) {
        int N = M.length;
        Integer[] marked = new Integer[N];
        for (int i = 0; i < N; i++) {
            marked[i] = i;
        }
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (M[i][j] == 1){
                    int oldMark = marked[j];
                    for (int k = 0; k < N; k++) {
                        if (marked[k] == oldMark) marked[k] = marked[i];
                    }
                }
            }
        }
        HashSet<Integer> set = new HashSet<>();
        set.addAll(Arrays.asList(marked));
        return set.size();
    }

	public static void main(String[] args) {
		Solution s = new Solution();
//		int[][] input1 = {
//		        {1, 1, 0},
//                {1, 1, 0},
//                {0, 0, 1}
//		};
//        System.out.println(s.findCircleNum(input1));
//        int[][] input2 = {
//		        {1, 1, 0},
//                {1, 1, 1},
//                {0, 1, 1}
//		};
//        System.out.println(s.findCircleNum(input2));
        int[][] input3 = {
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}
        };
        System.out.println(s.findCircleNum(input3));
	}
}