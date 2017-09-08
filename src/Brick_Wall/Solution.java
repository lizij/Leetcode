package Brick_Wall;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) return -1;

        /**
         * build a model to describe every brick and every line
         * each brick use boolean[3] to describe (0 and 2 is false with 1 is true). If it is adjacent to other bricks, change 0 or 2 to true.
         * It exceed the memory limit. However, I think it is still useful in some other ways.
         */
//        int height = wall.size();
//        int width = 0;
//        for (int i = 0; i < wall.get(0).size(); i++) {
//            width += wall.get(0).get(i);
//        }
//
//        boolean[][] bwall = new boolean[height][3 * width];
//        for (int i = 0; i < height; i++) {
//            bwall[i] = convert(wall.get(i), width);
//        }
//
//        int min = Integer.MAX_VALUE;
//        for (int col = 1; col < 3 * width - 1; col++) {
//            int count = 0;
//            for (int row = 0; row < height; row++) {
//                if (bwall[row][col]) count++;
//            }
//            min = Math.min(min, count);
//        }
//        return min;

        /**
         * Got from the first solution from the discuss
         * Store every brick's right border's occurrence in Map except the last one. The result is the height of wall minus the max of occurrence
         */
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxBorders = 0;
        for (List<Integer> list: wall){
            int length = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                length += list.get(i);
                map.put(length, map.getOrDefault(length, 0) + 1);
                maxBorders = Math.max(maxBorders, map.get(length));
            }
        }
        return wall.size() - maxBorders;
    }

    private boolean[] convert(List<Integer> row, int width){
        boolean[] line = new boolean[3 * width];
        for (int i = 0, last = 0, pos = 0; i < width; i++, last--) {
            line[3 * i + 1] = true;
            if (last > 0){
                line[3 * i - 1] = true;
                line[3 * i] = true;
            }
            if (last == 0){
                last = row.get(pos++);
            }
        }
        return line;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		List<List<Integer>> input1 = new ArrayList<>();
		input1.add(Arrays.asList(1, 2, 2, 1));
		input1.add(Arrays.asList(3, 1, 2));
		input1.add(Arrays.asList(1, 3, 2));
		input1.add(Arrays.asList(2, 4));
		input1.add(Arrays.asList(3, 1, 2));
		input1.add(Arrays.asList(1, 3, 1, 1));
//        input1.add(Arrays.asList(100000000));
//        input1.add(Arrays.asList(100000000));
//        input1.add(Arrays.asList(100000000));
        StdOut.println(s.leastBricks(input1));
	}
}