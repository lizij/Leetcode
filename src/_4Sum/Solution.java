package _4Sum;

import edu.princeton.cs.algs4.StdOut;

import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) return res;
        int N = nums.length;
        Arrays.sort(nums);
        int min = nums[0], max = nums[N - 1];
        if (4 * min > target || 4 * max < target) return res;

        HashMap<Integer, Sum> sumMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                Integer sum = nums[i] + nums[j];
                if (sum + 2 * min > target || sum + 2 * max < target) continue;
                if (!sumMap.containsKey(sum)){
                    sumMap.put(sum, new Sum(sum, new Integer[]{i, j}));
                }
                else{
                    sumMap.get(sum).pairs.add(new Integer[]{i, j});
                }
            }
        }

        for (Map.Entry<Integer, Sum> entry: sumMap.entrySet()){
            if (sumMap.containsKey(target - entry.getKey())){
                List<Integer[]> list1 = entry.getValue().pairs;
                List<Integer[]> list2 = sumMap.get(target - entry.getKey()).pairs;
                for (int i = 0; i < list1.size(); i++) {
                    for (int j = 0; j < list2.size(); j++) {
                        Integer[] pos1 = list1.get(i);
                        Integer[] pos2 = list2.get(j);
                        if (!pos1[0].equals(pos2[0]) && !pos1[0].equals(pos2[1]) && !pos1[1].equals(pos2[0]) && !pos1[1].equals(pos2[1])){
                            List<Integer> tmp = Arrays.asList(nums[pos1[0]], nums[pos1[1]], nums[pos2[0]], nums[pos2[1]]);
                            tmp.sort(Comparator.comparingInt(l -> l));
                            if (!res.contains(tmp)) res.add(tmp);
                        }
                    }
                }
            }
        }

        return res;
    }

    private class Sum{
        int value;
        List<Integer[]> pairs;
        Sum(int value, Integer[] pair){
            this.value = value;
            pairs = new ArrayList<>();
            pairs.add(pair);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> output1 = s.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        for (int i = 0; i < output1.size(); i++) {
            for (int j = 0; j < output1.get(i).size(); j++) {
                StdOut.print(output1.get(i).get(j) + " ");
            }
            StdOut.println();
        }
    }
}
