package Find_All_Numbers_Disappeared_in_an_Array;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int N = nums.length;
        if (N == 0) return list;
        Arrays.sort(nums);
        int index = 1;
        for (;index < nums[0];index++) list.add(index);
        for (int i = 0; i < N; i++){
            if (nums[i] > index){
                for (int j = index + 1; j < nums[i]; j++) list.add(j);
            }
            index = nums[i];
        }
        for (index++;index <= N;index++) list.add(index);
        return list;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for (int i: s.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1})){
            System.out.print(i + " ");
        }
    }
}
