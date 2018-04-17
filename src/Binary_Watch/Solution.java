package Binary_Watch;



import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num){
                    res.add(i + ":" + (j < 10 ? "0" + j : j));
                }
            }
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        for (String str: s.readBinaryWatch(1)){
            System.out.print(str + " ");
        }
	}
}