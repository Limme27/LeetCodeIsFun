package linkedList.twoPointers;

public class LLCycle_141 {
  public boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow.equals(fast)) return true;
    }
    return false;
  }
}