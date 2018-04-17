package Merge_Two_Sorted_Lists;

import Others.ListNode;
import Others.NodeList;


public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /**
         * init the first node to avoid t3 == null and create all new nodes based on t1 or t2 values.
         * Using the original data directly is not recommended except some special cases.
         * 20ms
         */
        ListNode res = new ListNode(0);
        for (ListNode t1 = l1, t2 = l2, t3 = res; t1 != null || t2 != null;t3 = t3.next){
            if ((t1 != null && t2 != null && t1.val < t2.val) || t2 == null) {
                t3.next = new ListNode(t1.val);
                t1 = t1.next;
            } else if ((t1 != null && t2 != null && t1.val >= t2.val) || t1 == null) {
                t3.next = new ListNode(t2.val);
                t2 = t2.next;
            }
        }
        return res.next;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.mergeTwoLists(new NodeList(new int[]{1,3,5,7}).head, new NodeList(new int[]{2,4,6,8,10,12}).head));
	}
}