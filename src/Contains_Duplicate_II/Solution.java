package Contains_Duplicate_II;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 0) return false;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList());
            for (int j = 0; j < list.size(); j++){
                if (i - list.get(j) <= k) return true;
            }
            list.add(i);
            map.put(nums[i], list);
        }
        return false;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.containsNearbyDuplicate(new int[]{-1, -1}, 1));
	}
}