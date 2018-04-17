package Maximum_Length_of_Pair_Chain;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) return 0;

        //brute force
//        Arrays.sort(pairs, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
//        int max = 0;
//        for (int i = 0; i < pairs.length; i++) {
//            int count = 1;
//            int[] last = pairs[i];
//            for (int j = i + 1; j < pairs.length; j++) {
//                int[] now = pairs[j];
//                if (now[0] >= last[0] && now[1] <= last[1]) last = now;
//                else if (now[0] > last[1]){
//                    last = now;
//                    count++;
//                }
//            }
//            max = Math.max(max, count);
//        }
//        return max;

        //greedy
        Arrays.sort(pairs, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        int count = 1;
        int[] last = pairs[0];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > last[1]){
                last = pairs[i];
                count++;
            }
        }
        return count;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
//		int[][] input1 = {
//		        {1, 2},
//                {2, 3},
//                {3, 4}
//		};
//        System.out.println(s.findLongestChain(input1));
//        int[][] input2 = {
//                {-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}
//        };
//        System.out.println(s.findLongestChain(input2));
        int[][] input2 = {{7,9},{4,5},{7,9},{-7,-1},{0,10},{3,10},{3,6},{2,3}};
        System.out.println(s.findLongestChain(input2));
	}
}