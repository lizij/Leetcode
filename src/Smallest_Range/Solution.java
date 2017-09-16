package Smallest_Range;

import edu.princeton.cs.algs4.StdOut;

import java.util.*;

public class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        /**
         * use PriorityQueue to decrease time costed by sort.
         * 269ms...
         */
        PriorityQueue<Element> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++){
            for (int n: nums.get(i)){
                max = Math.max(max, n);
                min = Math.min(min, n);
                Element e = new Element(n, i);
                queue.offer(e);
            }
        }

        int[] minRange = {min, max}, count = new int[nums.size()];
        Queue<Element> start = new LinkedList<>();
        Element end;
        do{
            end = queue.poll();
            count[end.from]++;
            start.offer(end);
            while (containsAll(count)){
                if (end.val - start.peek().val < minRange[1] - minRange[0]) minRange = new int[]{start.peek().val, end.val};
                count[start.peek().from]--;
                start.poll();
            }
        }while (queue.size() > 0);
        return minRange;
        /**
         * use HashMap to mark every number with its source, sort it and use slide window to detect the min range
         * 179ms
         */
//        HashMap<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < nums.size(); i++) {
//            List<Integer> list = nums.get(i);
//            for (int j: list){
//                List<Integer> from = map.get(j);
//                if (from == null){
//                    from = new ArrayList<>();from.add(i);
//                    map.put(j, from);
//                }
//                else from.add(i);
//            }
//        }
//
//        List<Map.Entry<Integer, List<Integer>>> entryList = new ArrayList<>(map.entrySet());
//        entryList.sort(Comparator.comparingInt(Map.Entry::getKey));
//        int start = 0;
//        int[] minRange = {entryList.get(0).getKey(), entryList.get(entryList.size() - 1).getKey()};
//        int[] count = new int[nums.size()];
//        for (int end = 0; end < entryList.size(); end++) {
//            addAll(count, entryList.get(end).getValue());
//            while (containsAll(count)){
//                int[] range = {entryList.get(start).getKey(), entryList.get(end).getKey()};
//                if (range[1] - range[0] < minRange[1] - minRange[0]){
//                    minRange = range;
//                }
//                removeAll(count, entryList.get(start).getValue());
//                start++;
//            }
//        }
//        return minRange;
    }

    private void addAll(int[] count, List<Integer> list){
        for (int n: list) count[n]++;
    }

    private boolean containsAll(int[] count){
        for (int n: count) {
            if (n == 0) return false;
        }
        return true;
    }

    private void removeAll(int[] count, List<Integer> list){
        for (int n: list) count[n]--;
    }

    private class Element{
        int val;
        int from;
        public Element(int val, int from){
            this.val = val;
            this.from = from;
        }
    }

	public static void main(String[] args) {
		Solution s = new Solution();
//		int[] output = s.smallestRange(Arrays.asList(Arrays.asList(4,10,15,24,26), Arrays.asList(0,9,12,20), Arrays.asList(5,18,22,30)));
		int[] output2 = s.smallestRange(Arrays.asList(Arrays.asList(1,3,5,7,9,10), Arrays.asList(2,4,6,8,10)));
		int[] output3 = s.smallestRange(Arrays.asList(Arrays.asList(1)));
        StdOut.println(output2[0] + "," + output2[1]);
	}
}