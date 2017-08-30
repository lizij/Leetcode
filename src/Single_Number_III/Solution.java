package Single_Number_III;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            if (i - 1 >= 0 && nums[i - 1] == nums[i]) continue;
            if (i + 1 <= nums.length - 1 && nums[i + 1] == nums[i]) continue;
            list.add(nums[i]);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {

    }
}
