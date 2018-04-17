package Bulb_Switcher;



public class Solution {
    public int bulbSwitch(int n) {
        int count = 0;
//        int[] bulbs = new int[n + 1];//1:on 0:off
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= i; j++) {
//                if (i % j == 0) bulbs[i] = 1 - bulbs[i];
//            }
//            if (bulbs[i] == 1) count++;
//        }
        for (count = 1; count * (count + 2) < n; count++);
        return count;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        for (int i = 1; i < 100; i++) {
            System.out.println(i + ":" + s.bulbSwitch(i));
        }
    }
}