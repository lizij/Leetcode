package Two_Sum_II_Input_array_is_sorted;



public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //may not have a solution
//        for (int i = 0; i < numbers.length; i++) {
//            if (2 * numbers[i] > target) break;
//            for (int j = i + 1; j < numbers.length; j++) {
//                if (numbers[i] + numbers[j] > target) break;
//                if (numbers[i] + numbers[j] == target) return new int[]{i, j};
//            }
//        }

        //will have exactly one solution
        int i, j;
        for (i = 0, j = numbers.length - 1; numbers[i] + numbers[j] != target;) {
            if (numbers[i] + numbers[j] < target) i++;
            else j--;
        }
        return new int[]{i + 1, j + 1};
    }

	public static void main(String[] args) {
		Solution s = new Solution();

        for (int i: s.twoSum(new int[]{2, 7, 11, 19}, 9)) System.out.print(i + " ");
	}
}