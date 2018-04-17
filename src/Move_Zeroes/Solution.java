package Move_Zeroes;



public class Solution {
    public void moveZeroes(int[] nums) {
        int N = nums.length;
        int count = 0, i = 0;
        while(i < N - count) {
            if (nums[i] == 0){
                for (int j = i; j <= N - 2; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[N - 1] = 0;
                count++;
                continue;
            }
            i++;
        }
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] input = {0, 1, 0, 3, 2};
		s.moveZeroes(input);
        for (int i: input) System.out.print(i + " ");
        System.out.println();
        int[] input2 = {0, 0, 1};
        s.moveZeroes(input2);
        for (int i: input2) System.out.print(i + " ");
        System.out.println();
        int[] input3 = {0};
        s.moveZeroes(input3);
        for (int i: input3) System.out.print(i + " ");
        System.out.println();
	}
}