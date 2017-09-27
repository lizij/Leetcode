package Freedom_Trail;

import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findRotateSteps(String ring, String key) {
        /**
         * use String.indexOf and lastIndexOf to implement clockwise and anticlockwise rotation.
         * Use String as the key type of map will reduce the efficiency of get(). But code is less.
         * 79ms
         */
//        Map<String, Map<Integer, Integer>> map = new HashMap<>();
//        int steps = dfs(ring, key, 0);

        /**
         * use Dial to implement clockwise and anticlockwise rotation
         * 42ms
         */
        int[][] mem = new int[ring.length()][key.length()];
        int steps = dfs(new Dial(ring), key, 0, mem);
        return steps + key.length();
    }

    private int dfs(String ring, String key, int pos, Map<String, Map<Integer, Integer>> map){
        if (pos == key.length()) return 0;
        if (map.containsKey(ring) && map.get(ring).containsKey(pos)) return map.get(ring).get(pos);
        char c = key.charAt(pos);
        int left = ring.indexOf(c);
        int right = ring.lastIndexOf(c);
        int afterLeft = left + dfs(ring.substring(left) + ring.substring(0, left), key, pos + 1, map);
        int afterRight = ring.length() - right + dfs(ring.substring(right) + ring.substring(0, right), key, pos + 1, map);
        int res = Math.min(afterLeft, afterRight);
        Map<Integer, Integer> ans = map.getOrDefault(ring, new HashMap<>());
        ans.put(pos, res);
        map.put(ring, ans);
        return res;
    }

    private int dfs(Dial dial, String key, int pos, int[][] mem){
        if (pos == key.length()) return 0;
        int precur = dial.getCur();
        if (mem[precur][pos] != 0) return mem[precur][pos];
        char c = key.charAt(pos);
        int left = dial.rotate(c, false) + dfs(dial, key, pos + 1, mem);
        dial.setCur(precur);
        int right = dial.rotate(c, true) + dfs(dial, key, pos + 1, mem);
        dial.setCur(precur);
        mem[precur][pos] = Math.min(left, right);
        return mem[precur][pos];
    }

    class Dial{
        char[] ring;
        int cur;
        Dial(String ring){
            this.ring = ring.toCharArray();
            cur = 0;
        }

        int rotate(char c, boolean right){
            int count = 0;
            while (ring[cur] != c){
                cur = (right ? cur + 1: cur - 1 + ring.length) % ring.length;
                count++;
            }
            return count;
        }

        int getCur() { return cur; }

        void setCur(int cur) { this.cur = cur; }
    }

	public static void main(String[] args) {
		Solution s = new Solution();
//        StdOut.println(s.findRotateSteps("godding", "gd"));//4
        StdOut.println(s.findRotateSteps("iotfo", "fioot"));
	}
}