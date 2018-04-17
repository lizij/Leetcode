package Add_Two_Numbers;

import Others.ListNode;
import Others.NodeList;


public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode res = null, tmp1 = l1, tmp2 = l2, tmp3 = null;
    	boolean carry = false;
        while (tmp1!= null || tmp2 != null){
        	//get digit
        	int value = getValue(tmp1) + getValue(tmp2);

        	//add carry
        	if (carry){
        		value += 1;
        		carry = false;
			}

			//carry exist?
			if (value >= 10){
        		value -= 10;
        		carry = true;
			}

			//initialize res and add value to tail of res
			if (res == null){
				res = tmp3 = new ListNode(value);
			}
			else{
				tmp3.next = new ListNode(value);
				tmp3 = tmp3.next;
			}

			//move to next pos
			if (tmp1 != null) tmp1 = tmp1.next;
			if (tmp2 != null) tmp2 = tmp2.next;
		}
		if (carry){
        	tmp3.next = new ListNode(1);
		}
		return res;
    }

    private int getValue(ListNode node){
    	if (node == null) return 0;
    	return node.val;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		NodeList l1 = new NodeList(new int[]{2, 5, 3});
		NodeList l2 = new NodeList(new int[]{5, 6, 7, 9});
		ListNode res = s.addTwoNumbers(l1.head, l2.head);
		while (res != null){
			System.out.print(res.val + "->");
			res = res.next;
		}
	}
}