package Plus_One;



import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> num = Arrays.stream(digits).boxed().collect(Collectors.toList());
        num.set(num.size() - 1, num.get(num.size() - 1) + 1);
        int carry = 0;
        for (int i = num.size() - 1; i >= 0; i--) {
            int val = num.get(i) + carry;
            num.set(i, val % 10);
            carry = val / 10;
        }
        if (carry == 1) num.add(0, 1);
//        System.out.println(num);
        return num.stream().mapToInt(Integer::intValue).toArray();
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.plusOne(new int[]{8,1}));
        System.out.println(s.plusOne(new int[]{9,9}));
	}
}