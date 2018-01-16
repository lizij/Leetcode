package Falling_Squares;

import sun.nio.cs.ext.MacHebrew;

import java.util.*;

public class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        if (positions == null || positions.length == 0 || positions[0].length == 0) {
            return null;
        }

        /**
         * There are 2 basic operations:
         * update: Update our notion of board after dropping a square
         * query: Find the largest height in the current board on some interval
         * Since there are up to 2 * positions.length points (namely the left and right edges of each square)
         * we use Coordinate Compression to map these points to adjacent integers.
         */

        // Coordinate Compression
        Set<Integer> coords = new HashSet<>(); // coordinates without duplicates
        for (int[] pos: positions) {
            coords.add(pos[0]); // left edge
            coords.add(pos[0] + pos[1] - 1); // right edge
        }

        // sort coordinates
        List<Integer> sortedCoords = new ArrayList<>(coords);
        sortedCoords.sort((o1, o2) -> o1 - o2);

        // map coordinates to adjacent integers
        Map<Integer, Integer> index = new HashMap<>();
        int t = 0;
        for (int coord: sortedCoords) {
            index.put(coord, t++);
        }

        int maxHeight = 0; // current max height
        List<Integer> res = new ArrayList<>();

        /**
         * Brute force solution: simulate each square's drop directly. Maybe the best solution
         * 119ms
         */
//        int[] heights = new int[t];
//        for (int[] pos: positions) {
//            int leftCoordIndex = index.get(pos[0]); // left coordinate index
//            int rightCoordIndex = index.get(pos[0] + pos[1] - 1); // right coordinate index
//            int height = query(heights, leftCoordIndex, rightCoordIndex) + pos[1]; // get the top edge height

//            update(heights, leftCoordIndex, rightCoordIndex, height);
//            maxHeight = Math.max(maxHeight, height); // get the current max height
//            res.add(maxHeight);
//        }

        /**
         * Segment Tree with Lazy Propagation solution, quite similar with brute force. Not understand actually :(
         * Segment trees work by breaking intervals into a disjoint sum of component intervals,
         * whose number is at most log(width).
         * The motivation is that when we change an element,
         * we only need to change log(width) many intervals
         * that aggregate on an interval containing that element.
         * When we want to update an interval all at once,
         * we need to use lazy propagation to ensure good run-time complexity
         * 111ms
         */

//        SegmentTree stree = new SegmentTree(t);

//        for (int[] pos: positions) {
//            int leftCoordIndex = index.get(pos[0]); // left coordinate index
//            int rightCoordIndex = index.get(pos[0] + pos[1] - 1); // right coordinate index
//            int height = stree.query(leftCoordIndex, rightCoordIndex) + pos[1]; // get the top edge's height (the bottom edge's height + length of the edge)

//            stree.update(leftCoordIndex, rightCoordIndex, height);
//            maxHeight = Math.max(maxHeight, height); // get the current max height
//            res.add(maxHeight);
//        }

        /**
         * Easy understood solution without Coordinate Compression
         * use Interval to represent a square with left edge, right edge and height
         * height represent the intersected square's max height
         * 152ms
         */

        // List<Interval> intervals = new ArrayList<>();
        // for (int[] pos: positions) {
        //     Interval cur = new Interval(pos[0], pos[0] + pos[1] - 1, pos[1]);
        //     maxHeight = Math.max(maxHeight, getHeight(intervals, cur));
        //     res.add(maxHeight);
        // }

        return res;
    }

    private int getHeight(List<Interval> intervals, Interval cur) {
        int preMaxHeight = 0;
        for (Interval intv: intervals) {
            if (cur.right < intv.left || cur.left > intv.right) continue; // not intersect
            preMaxHeight = Math.max(preMaxHeight, intv.height);
        }
        cur.height += preMaxHeight;
        intervals.add(cur);
        return cur.height;
    }

    class Interval {
        int left, right, height;

        public Interval(int left, int right, int height) {
            this.left = left;
            this.right = right;
            this.height = height;
        }
    }

    class SegmentTree {
        // a kind of binary search tree
        int size;
        int height;
        int[] tree, lazy;

        public SegmentTree(int size) {
            this.size = size;
            height = 1;

            // compute the total height we need, (1 << height) is equal to (height *= 2)
            while ((1 << height) < size) {
                height++;
            }

            tree = new int[2 * size]; // size of leaves and size - 1 of non-leaves
            lazy = new int[size]; // max values of tree[x]
        }

        private void apply(int x, int val) {
            // update tree[x] to max(tree[x], val)
            tree[x] = Math.max(tree[x], val);
            if (x < size) {
                lazy[x] = Math.max(lazy[x], val);
            }
        }

        private void pull(int x) {
            while (x > 1) {
                x >>= 1;
                tree[x] = Math.max(tree[x * 2], tree[x * 2 + 1]);
                tree[x] = Math.max(tree[x], lazy[x]);
            }
        }

        private void push(int x) {
            for (int h = height; h > 0; h--) {
                int y = x >> h;
                if (lazy[y] > 0) {
                    apply(y * 2, lazy[y]);
                    apply(y * 2 + 1, lazy[y]);
                    lazy[y] = 0;
                }
            }
        }

        public void update(int lo, int hi, int h) {
            lo += size;
            hi += size;
            int originlo = lo, originhi = hi, res = 0;
            while (lo <= hi) {
                if ((lo & 1) == 1) {
                    apply(lo++, h);
                }
                if ((hi & 1) == 0) {
                    apply(hi--, h);
                }
                lo >>= 1;
                hi >>= 1;
            }
            pull(originlo);
            pull(originhi);
        }

        public int query(int lo, int hi) {
            lo += size;
            hi += size;
            push(lo);
            push(hi);

            int res = 0;
            while (lo <= hi) {
                if ((lo & 1) == 1) {
                    res = Math.max(res, tree[lo++]);
                }
                if ((hi & 1) == 0) {
                    res = Math.max(res, tree[hi--]);
                }
                lo >>= 1;
                hi >>= 1;
            }

            return res;
        }
    }

    private int query(int[] heights, int lo, int hi) {
        // return the max value from left to right
        int res = 0;
        for (int i = lo; i <= hi; i++) {
            res = Math.max(res, heights[i]);
        }
        return res;
    }

    private void update(int[] heights, int lo, int hi, int height) {
        // update value to max(height[i], height) from lo to hi
        for (int i = lo; i <= hi; i++) {
            heights[i] = Math.max(heights[i], height);
        }
    }

    public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.fallingSquares(new int[][]{{1, 2}, {2, 3}, {6, 1}})); // [2, 5, 5]
		System.out.println(s.fallingSquares(new int[][]{{100, 100}, {200, 100}})); // [100, 200]
	}
}