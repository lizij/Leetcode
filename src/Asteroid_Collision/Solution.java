package Asteroid_Collision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return null;
        }

        /**
         * Collision analysis. Assuming a[i] > 0, a[i + 1] < 0:
         * 1. a[i] + a[i + 1] > 0: delete a[i + 1]
         * 2. a[i] + a[i + 1] < 0: delete a[i], i-- to compare the origin a[i - 1] with a[i + 1]
         * 3. a[i] + a[i + 1] == 0: delete a[i] and a[i + 1], i-- to compare the origin a[i - 1] with a[i + 2]
         * 178ms
         */

//        List<Integer> res = new ArrayList<>();
//        for (int a: asteroids) {
//            res.add(a);
//        }
//        int pos = 0;
//        while (pos < res.size() - 1) {
//            if (pos >= 0) {
//                int cur = res.get(pos);
//                int next = res.get(pos + 1);
//                if (cur > 0 && next < 0) {
//                    if (cur + next > 0) {
//                        res.remove(pos + 1);
//                    } else if (cur + next < 0) {
//                        res.remove(pos);
//                        pos--;
//                    } else {
//                        res.remove(pos + 1);
//                        res.remove(pos);
//                        pos--;
//                    }
//                    continue;
//                }
//            }
//            pos++;
//        }
//        return res.stream().mapToInt(o -> o).toArray();

        /**
         * Stack solution
         * 140ms
         */
        Stack<Integer> stack = new Stack<>();
        int pos = 0;
        while (pos < asteroids.length) {
            if (stack.isEmpty()) {
                stack.push(asteroids[pos++]);
            } else {
                int peek = stack.peek();
                if (peek > 0 && asteroids[pos] < 0) {
                    if (peek + asteroids[pos] > 0) {
                        pos++;
                    } else if (peek + asteroids[pos] < 0) {
                        stack.pop();
                    } else {
                        stack.pop();
                        pos++;
                    }
                } else {
                    stack.push(asteroids[pos++]);
                }
            }
        }
        return new ArrayList<>(stack).stream().mapToInt(o -> o).toArray();
    }

    public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(Arrays.toString(s.asteroidCollision(new int[]{5, 10, -5}))); // [5, 10]
		System.out.println(Arrays.toString(s.asteroidCollision(new int[]{8, -8}))); // []
		System.out.println(Arrays.toString(s.asteroidCollision(new int[]{10, 2, -5}))); // [10]
		System.out.println(Arrays.toString(s.asteroidCollision(new int[]{-2, -1, 1, 2}))); // [-2, -1, 1, 2]
	}
}