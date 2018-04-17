package Teemo_Attacking;



public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int N = timeSeries.length;
        if (N == 0) return 0;
        int count = 0;
        for (int i = 0, last = 0; i < N; i++) {
            int j = Math.max(last, timeSeries[i]);
            for (; j < timeSeries[i] + duration; j++) {
                count++;
            }
            last = j;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findPoisonedDuration(new int[]{1, 4}, 2));
        System.out.println(s.findPoisonedDuration(new int[]{1, 2}, 2));
    }
}
