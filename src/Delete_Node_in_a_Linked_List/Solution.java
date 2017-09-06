package Delete_Node_in_a_Linked_List;

import Others.ListNode;
import Others.NodeList;

public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
	}
}