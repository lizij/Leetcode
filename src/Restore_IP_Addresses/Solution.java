package Restore_IP_Addresses;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        /**
         * use depth first traverse
         * 7ms
         */
        Set<String> set = new HashSet<>();
        dfs(s, new ArrayList<>(), set);
        return new ArrayList<>(set);
    }

    private void dfs(String s, List<Integer> addr, Set<String> addrs) {
        if (addr.size() == 3) {
            if (s.length() == 0 || s.length() > 3 || s.startsWith("0") && s.length() > 1 || Integer.parseInt(s) > 255) return;
            addrs.add(addr.get(0) + "." + addr.get(1) + "." + addr.get(2) + "." + s);
            return;
        }
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            val = val * 10 + s.charAt(i) - '0';
            if (val <= 255) {
                addr.add(val);
                dfs(s.substring(i + 1), addr, addrs);
                addr.remove(addr.size() - 1);
                if (val == 0) break;
            } else break;
        }
    }

	public static void main(String[] args) {
		Solution s = new Solution();
//        StdOut.println(s.restoreIpAddresses("25525511135"));//255.255.11.135  255.255.111.35
//        StdOut.println(s.restoreIpAddresses("0000"));//0.0.0.0
//        StdOut.println(s.restoreIpAddresses("0279245587303"));//[]
        StdOut.println(s.restoreIpAddresses("010010"));//0.10.0.10  0.100.1.0
	}
}