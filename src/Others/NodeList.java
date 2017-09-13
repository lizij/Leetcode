package Others;

public class NodeList {
    public ListNode head;
    public ListNode tail;

    public NodeList(int[] vals){
        for (int i = 0; i < vals.length; i++) {
            ListNode node = new ListNode(vals[i]);
            if (head == null || tail == null) {
                head = node;
                tail = node;
            }
            else {
                tail.next = node;
                tail = node;
            }
        }
    }

    @Override
    public String toString() {
        return head.toString();
    }
}
