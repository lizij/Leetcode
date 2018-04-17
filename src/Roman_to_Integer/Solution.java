package Roman_to_Integer;



import java.util.HashMap;

public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('X', 10);
        map.put('C', 100);
        map.put('M', 1000);
        map.put('V', 5);
        map.put('L', 50);
        map.put('D', 500);

        int res = 0, N = s.length();
        for (int i = N - 1, last = -1; i >= 0; i--) {
            int value = map.get(s.charAt(i));
            if (last == -1) last = value;
            if (value < last){
                res -= value;
            }
            else {
                res += value;
                last = value;
            }
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
//        System.out.println(s.romanToInt("DCXXI"));
        System.out.println(s.romanToInt("MCMXCVI"));
	}
}