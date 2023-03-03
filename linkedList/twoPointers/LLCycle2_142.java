package linkedList.twoPointers;
// 142 -> 287
public class LLCycle2_142 {
  public ListNode detectCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow.equals(fast)) {
        fast = head;
        while (!slow.equals(fast)) {
          slow = slow.next;
          fast = fast.next;
        }
        return slow;
      }
    }
    return null;
  }
}
