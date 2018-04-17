package Map_Sum_Pairs;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private MapSum mapSum;
    public Solution(){
        mapSum = new MapSum();
    }
    public class MapSum {
        HashMap<String, Integer> map;

        /**
         * Initialize your data structure here.
         */
        public MapSum() {
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            map.put(key, val);
        }

        public int sum(String prefix) {
            int sum = 0;
            for (Map.Entry<String, Integer> entry: map.entrySet()){
                if (entry.getKey().startsWith(prefix)) sum += entry.getValue();
            }
            return sum;
        }

        /**
         * Your MapSum object will be instantiated and called as such:
         * MapSum obj = new MapSum();
         * obj.insert(key,val);
         * int param_2 = obj.sum(prefix);
         */
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.mapSum.insert("apple", 3);
        System.out.println(s.mapSum.sum("ap"));
        s.mapSum.insert("app", 2);
        System.out.println(s.mapSum.sum("ap"));
    }
}