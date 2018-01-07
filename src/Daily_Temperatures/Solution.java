package Daily_Temperatures;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.empty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            res[i] = stack.empty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] output = s.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}); // 1, 1, 4, 2, 1, 1, 0, 0
        for (int n: output) {
            System.out.print(n + " ");
        }
    }
}
