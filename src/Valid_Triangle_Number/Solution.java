package Valid_Triangle_Number;



import java.util.Arrays;

public class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length, res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (isValid(nums[i], nums[j], nums[k])) res++;
                }
            }
        }
        return res;
    }

    private boolean isValid(int a, int b, int c){
        return a + b > c;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.triangleNumber(new int[]{2, 2, 3, 4}));
	}
}