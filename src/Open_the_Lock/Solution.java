package Open_the_Lock;

import java.util.*;

public class Solution {
    public int openLock(String[] deadends, String target) {
        if (deadends == null || deadends.length == 0 || target == null || target.length() != 4) {
            return -1;
        }

        /**
         * BFS solution
         * In each step, we rotate one of the 4 wheels 1 slot.
         * eg. for 0000, its rotation result is one of [1000, 0100, 0010, 0001, 9000, 0900, 0090, 0009]
         * We add these results in queue with a null as an start, to mark that one rotation operation begins
         * In each loop, we poll a node from queue
         * 1. If it's a normal node,
         *      1.1. If it's target, return result
         *      1.2. If it's not target or dead ends, add its all rotation results into queue
         * 2. If it's null, add 1 to our result
         * 270ms
         */
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));

        String init = "0000";

        if (dead.contains(init)) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(init);
        queue.offer(null); // mark that one of 4 wheels has been rotated 1 slot

        Set<String> visited = new HashSet<>();
        visited.add(init);

        int res = 0;

        while (!queue.isEmpty()) {
            String node = queue.poll();
            if (node == null) {
                res++;
                if (queue.peek() != null) {
                    queue.offer(null);
                }
            } else if (node.equals(target)) {
                return res;
            } else if (!dead.contains(node)) {
                for (int i = 0; i < 4; i++) {
                    for (int j = -1; j <= 1; j += 2) {
                        char digit = (char) (((node.charAt(i) - '0') + j + 10) % 10 + '0');
                        String next = node.substring(0, i) + digit + node.substring(i + 1);
                        if (!visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                }
            }
        }
        return -1;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202")); // 6
		System.out.println(s.openLock(new String[]{"8888"}, "0009")); // 1
		System.out.println(s.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888")); // -1
		System.out.println(s.openLock(new String[]{"0000"}, "8888")); // -1
	}
}