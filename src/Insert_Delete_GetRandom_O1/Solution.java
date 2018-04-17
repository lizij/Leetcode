package Insert_Delete_GetRandom_O1;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {
    RandomizedSet randomizedSet;
    public Solution(){randomizedSet = new RandomizedSet();}
    public class RandomizedSet {
        Random r;
        List<Integer> data;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            r = new Random();
            data = new ArrayList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (data.contains(val)) return false;
            data.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!data.contains(val)) return false;
            data.remove((Integer) val);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return data.get(r.nextInt(data.size()));
        }
    }

    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.randomizedSet.insert(1));//true
        System.out.println(s.randomizedSet.remove(2));//false
        System.out.println(s.randomizedSet.insert(2));//true
        System.out.println(s.randomizedSet.getRandom());//1 or 2
        System.out.println(s.randomizedSet.remove(1));//true
        System.out.println(s.randomizedSet.insert(2));//false
        System.out.println(s.randomizedSet.getRandom());//2
	}
}