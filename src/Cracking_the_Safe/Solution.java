package Cracking_the_Safe;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String crackSafe(int n, int k) {
        if (n < 1 || k < 1) {
            return null;
        }

        /**
         * DFS & backtrack solution
         * The result need to contains k^n of cases. Assuming them already stored as a set:
         * eg. If n == 1 and k == 2, the set is {"0", "1"}. If n == 2 and k == 2, the set is {"00", "01", "10", "11"}
         * Start with n of '0' case in the String builder, and an empty set. Then get last of n - 1 letters of builder as the new prefix to try building new cases.
         * If the set's size reaches k^n, the builder is finished.
         * 19ms
         */
        int goal = (int) Math.pow(k, n);
        Set<String> cases = new HashSet<>();

        // init with n of '0'
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append('0');
        }
        cases.add(builder.toString());

        // dfs to find the result
        dfs(builder, goal, cases, n, k);

        return builder.toString();
    }

    private boolean dfs(StringBuilder builder, int goal, Set<String> cases, int n, int k) {
        // builder has contained all cases
        if (cases.size() == goal) {
            return true;
        }

        // get last n - 1 letters as prefix
        String pre = builder.substring(builder.length() - n + 1, builder.length());

        for (int i = 0; i < k; i++) {
            String newcase = pre + i; // build a new case
            if (!cases.contains(newcase)) {
                cases.add(newcase);
                builder.append(i);
                if (dfs(builder, goal, cases, n, k)) {
                    return true;
                } else {
                    cases.remove(newcase);
                    builder.deleteCharAt(builder.length() - 1);
                }
            }
        }
        return false;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.crackSafe(1, 2)); // "01", "10"
        System.out.println(s.crackSafe(2, 2)); // "01100", "10011", "11001"
	}
}