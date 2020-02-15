package LinkedLists;

public class ReverseNodesinKGroup {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null || k <= 1) {
                return head;
            }

            ListNode dummyNode = new ListNode(0);
            dummyNode.next = head;

            ListNode prev = dummyNode;
            ListNode curr = head;

            int count = 0;
            while (curr != null) {
                count++;
                if (count % k != 0) {
                    curr = curr.next;
                } else {
                    ListNode next = curr.next;

                    // Reverse the list
                    curr.next = null;
                    List<ListNode> result = reverseList(prev.next);

                    prev.next = result.get(0);
                    ListNode tail = result.get(1);
                    tail.next = next;
                    prev = tail;
                    curr = next;
                }
            }

            return dummyNode.next;
        }

        private List<ListNode> reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            ListNode tail = head;

            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            List<ListNode> result = new ArrayList<>();
            result.add(prev);
            result.add(tail);

            return result;

        }
    }
}
