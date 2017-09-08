package Contains_Duplicate_III;

import edu.princeton.cs.algs4.StdOut;

import java.util.*;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length == 0) return false;
        int N = nums.length;
        HashMap<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(i, (long)nums[i]);
        }
        List<Map.Entry<Integer, Long>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparingLong(Map.Entry::getValue));
        for (int i = 0; i < list.size() - 1; i++) {
            Map.Entry<Integer, Long> e1 = list.get(i);
            for (int j = i + 1; j < N; j++) {
                Map.Entry<Integer, Long> e2 = list.get(j);
                if (e2.getValue() - e1.getValue() > t) break;
                if (Math.abs(e2.getKey() - e1.getKey()) <= k) return true;
            }
        }
        return false;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
//        StdOut.println(s.containsNearbyAlmostDuplicate(new int[]{1, 3, 1}, 1, 2));
        StdOut.println(s.containsNearbyAlmostDuplicate(new int[]{1, 3, 6, 2}, 1, 2));
        StdOut.println(s.containsNearbyAlmostDuplicate(new int[]{1, 2}, 0, 1));
//        StdOut.println(s.containsNearbyAlmostDuplicate(new int[]{-1,2147483647}, 1, 2147483647));
	}
}