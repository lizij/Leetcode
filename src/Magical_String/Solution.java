package Magical_String;



public class Solution {
    public int magicalString(int n) {
        int[] seed = new int[n >= 6 ? n : 6];
        seed[0] = seed[3] = seed[4] = 1;
        seed[1] = seed[2] = seed[5] = 2;
        int tail = 6;
        if (n > tail){
            int[] c = {1, 2};
            for (int cur = 4, d = 0; tail < n;d = 1 - d, cur++){
                int len = seed[cur];
                for (int i = 0; i < len; i++) {
                    seed[tail++] = c[d];
                    if (tail >= n) break;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (seed[i] == 1) count++;
        }
        return count;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
//        System.out.println(s.magicalString(6));
//        System.out.println(s.magicalString(11));
        System.out.println(s.magicalString(1));
	}
}