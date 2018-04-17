package Remove_Element;



public class Solution {
    public int removeElement(int[] nums, int val) {
        int res = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] == val){
                System.arraycopy(nums, i + 1, nums, i, res - i);
                nums[res--] = Integer.MIN_VALUE;
            }
        }
        return res + 1;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(s.removeElement(new int[]{4, 4, 0, 1, 0, 2}, 0));
	}
}