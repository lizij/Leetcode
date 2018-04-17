package Find_Peak_Element;



import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int findPeakElement(int[] nums) {
        /**
         * Sequential Search
         * 86ms
         */
//        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
//        list.add(0, Integer.MIN_VALUE);
//        list.add(Integer.MIN_VALUE);
//        for (int i = 1; i < list.size() - 1; i++) {
//            if (list.get(i - 1) < list.get(i) && list.get(i) > list.get(i + 1)) return i - 1;
//        }
//        return -1;
        /**
         * Binary Search
         * 0ms
         */
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] < nums[mid + 1]) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.findPeakElement(new int[]{1,2,3,1}));
	}
}