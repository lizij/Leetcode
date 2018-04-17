package Linked_List_Random_Node;

import Others.ListNode;


import java.util.HashMap;
import java.util.Random;

public class Solution {
    Random random;
    ListNode head;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        random = new Random();
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode node = head;
        ListNode res = head;
        for (int i = 1;node != null;i++, node = node.next){
            if (random.nextInt(i) == 0) res = node;
        }
        return res.val;
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
	public static void main(String[] args) {
	    ListNode head = new ListNode(1);
	    head.next = new ListNode(2);
	    head.next.next = new ListNode(3);
		Solution s = new Solution(head);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 9999; i++) {
            int val = s.getRandom();
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        for (Integer i: map.keySet()){
            System.out.println(i + ":" + map.get(i));
        }
    }
}