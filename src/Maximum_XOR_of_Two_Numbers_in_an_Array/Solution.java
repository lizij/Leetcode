package Maximum_XOR_of_Two_Numbers_in_an_Array;



import java.util.HashSet;

public class Solution {
    public int findMaximumXOR(int[] nums) {
        int N = nums.length;
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < N; j++) {
               set.add(nums[j] & mask);
            }

            int tmp = max | (1 << i);
            for (int prefix : set){
                if (set.contains(tmp ^ prefix)){
                    max = tmp;
                    break;
                }
            }
        }

        //brute force
//        for (int i = 0; i < N; i++) {
//            for (int j = i + 1; j < N; j++) {
//                max = Math.max(max, nums[i] ^ nums[j]);
//            }
//        }
        return max;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
	}
}