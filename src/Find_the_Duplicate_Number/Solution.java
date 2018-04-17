package Find_the_Duplicate_Number;



public class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.findDuplicate(new int[]{1, 2, 3, 4, 2}));
        System.out.println(s.findDuplicate(new int[]{1, 2, 3, 2, 2}));
	}
}