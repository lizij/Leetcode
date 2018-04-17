package Array_Nesting;



import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int arrayNesting(int[] nums) {
        int N = nums.length;
        if (N == 0) return 0;
        int maxLength = 0;

        //brute force
//        for (int i = 0; i < N; i++) {
//            boolean[] marked = new boolean[N];
//            int count = 0;
//            for (int j = i;!marked[j];j = nums[j]){
//                marked[j] = true;
//                count++;
//            }
//            if (count > maxLength){
//                maxLength = count;
//            }
//        }

        //Wrong version with deque
//        List<ArrayDeque<Integer>> dequeList = new ArrayList<>();
//        for (int i = 0; i < N; i++) {
//            int j = 0;
//            for (; j < dequeList.size(); j++) {
//                ArrayDeque<Integer> deque = dequeList.get(j);
//                if (deque.getFirst() == nums[i] && deque.getLast() != i){
//                    deque.addFirst(i);
//                    break;
//                }
//                else if (deque.getLast() == i && deque.getFirst() != nums[i]){
//                    deque.addLast(nums[i]);
//                    break;
//                }
//            }
//            if (j == dequeList.size()){
//                ArrayDeque<Integer> deque = new ArrayDeque<>();
//                deque.addLast(i);
//                if (i != nums[i]) deque.addLast(nums[i]);
//                dequeList.add(deque);
//            }
//        }
//
//        for (int i = 0; i < dequeList.size(); i++) {
//            maxLength = Math.max(maxLength, dequeList.get(i).size());
//        }

        boolean[] marked = new boolean[N];
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = i; !marked[j] ; j = nums[j]) {
                marked[j] = true;
                count++;
            }
            maxLength = Math.max(maxLength, count);
        }
        return maxLength;
    }


	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2}));
        System.out.println(s.arrayNesting(new int[]{0,1,2}));
        System.out.println(s.arrayNesting(new int[]{2,3,1,4,0}));
	}
}