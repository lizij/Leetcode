package Flatten_Nested_List_Iterator;

import Others.NestedInteger;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution{
    public class NestedIterator implements Iterator<Integer> {
        Queue<Integer> queue;

        public NestedIterator(List<NestedInteger> nestedList) {
            queue = new LinkedList<>();
            init(nestedList);
        }

        private void init(List<NestedInteger> nestedList){
            for (NestedInteger nestedInteger: nestedList){
                if (nestedInteger.isInteger()) queue.add(nestedInteger.getInteger());
                else{
                    init(nestedInteger.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return hasNext() ? queue.poll() : null;
        }

        @Override
        public boolean hasNext() {
            return queue.size() > 0;
        }
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}