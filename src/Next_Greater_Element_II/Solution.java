package Next_Greater_Element_II;



import java.util.Stack;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];
        if (N == 0) return res;
//        for (int i = 0; i < N; i++) {
//            res[i] = -1;
//            for (int j = 1; j < N; j++) {
//                int pos = i + j >= N ? i + j - N : i + j;
//                if (nums[pos] > nums[i]){
//                    res[i] = nums[pos];
//                    break;
//                }
//            }
//        }
        Stack<Integer> stack = new Stack<>();
        for (int i = N - 1; i >= 0; i--) stack.push(i);
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
//		for (int i: s.nextGreaterElements(new int[]{1, 2, 1})) System.out.print(i + " ");System.out.println();
		for (int i: s.nextGreaterElements(new int[]{5, 4, 3, 2, 1})) System.out.print(i + " ");System.out.println();
	}
}