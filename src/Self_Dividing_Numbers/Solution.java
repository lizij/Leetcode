package Self_Dividing_Numbers;

import java.util.ArrayList;
import java.util.List;

public class Solution{
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean isSelfDividingNumber(int num) {
        if (num < 10) return true;
        int[] digits = getDigits(num);
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0 || num % digits[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private int[] getDigits(int num) {
        List<Integer> digits = new ArrayList<>();
        while (num > 0) {
            digits.add(num % 10);
            num /= 10;
        }
        return digits.stream().mapToInt(i -> i).toArray();
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.selfDividingNumbers(1, 22)); // 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22
	}
}