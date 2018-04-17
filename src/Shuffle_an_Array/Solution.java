package Shuffle_an_Array;



import java.util.Random;

public class Solution {
    int[] nums;
    Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int N = nums.length;
        int[] shuffle = nums.clone();
        for (int i = 1; i < N; i++) {
            int j = random.nextInt(i + 1);
            int tmp = shuffle[j];
            shuffle[j] = shuffle[i];
            shuffle[i] = tmp;
        }
        return shuffle;
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
	public static void main(String[] args) {
		Solution s = new Solution(new int[]{1, 2, 3});
        for (int i: s.shuffle()) System.out.print(i + " ");
	}
}