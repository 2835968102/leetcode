package linkedlist;

/**
 * 23. 合并 K 个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 *
 * 解法一：依次合并
 * - 从空链表开始，依次和每个有序链表进行合并
 * - 两两合并时使用双指针完成有序合并
 *
 * Time: O(kn)
 * Space: O(1)
 *
 * 解法二：分治合并
 * - 将 k 个链表不断二分，递归合并左右两部分
 * - 每一层总共处理 n 个节点，共有 logk 层
 *
 * Time: O(n log k)
 * Space: O(log k)
 */
public class _23_MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;

        for (ListNode list : lists) {
            result = mergeTwoLists(result, list);
        }
        return result;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return lists[left];
        }

        int mid = (left + right) >> 1;
        return mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        ListNode aPointer = a;
        ListNode bPointer = b;

        while (aPointer != null && bPointer != null) {
            if (aPointer.val < bPointer.val) {
                tail.next = aPointer;
                aPointer = aPointer.next;
            } else {
                tail.next = bPointer;
                bPointer = bPointer.next;
            }
            tail = tail.next;
        }

        tail.next = aPointer != null ? aPointer : bPointer;
        return dummyHead.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
