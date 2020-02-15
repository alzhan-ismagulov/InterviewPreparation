package LinkedLists;

public class MergeKSortedLists {
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            // Initialize the priority queue with customized comparator
            PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparing(node -> node.val));
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    queue.offer(lists[i]);
                }
            }
            if (queue.isEmpty()) return null;

            // Append the priority queue with all items
            ListNode dummy = new ListNode(0);
            ListNode head = dummy;
            while (!queue.isEmpty()) {
                ListNode node = queue.poll();
                if (node.next != null) {
                    queue.offer(node.next);
                }
                head.next = node; // link
                head = head.next;
            }
            return dummy.next;
        }
    }

    public class Solution2 {
        public ListNode mergeKLists(List<ListNode> lists) {
            if (lists == null || lists.size() == 0) {
                return null;
            }
            PriorityQueue<ListNode> queue =
                    new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(){
                        public int compare(ListNode a, ListNode b){
                            return a.val - b.val;
                        }
                    });

            //populate queue with k lists' header
            for (int i = 0; i < lists.size(); i++) {
                if (lists.get(i) != null) {
                    queue.offer(lists.get(i));
                }
            }

            ListNode dummy = new ListNode(0);
            ListNode node = dummy;
            while (!queue.isEmpty()) {
                ListNode curr = queue.poll();
                node.next = curr;

                if (curr.next != null) {
                    queue.offer(curr.next);
                }

                node = node.next;
            }

            return dummy.next;
        }
    }
}
