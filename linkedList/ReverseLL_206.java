package linkedList;

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  void printNode() {
    ListNode curr = this; 
    while (curr.next != null) {
      System.out.print(Integer.toString(curr.val)+"->");
      curr = curr.next;
    }
    System.out.println(curr.val);
  }
}

public class ReverseLL_206 {
  public static ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode newHead = null;
    while (head != null) {
      ListNode tmp = head.next;
      head.next = newHead;
      newHead = head;
      head = tmp;
    }
    return newHead;    
  }

  public static ListNode reverseLLRecur(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode curr = head.next;
    head.next = null;
    ListNode newHead = reverseLLRecur(curr);
    curr.next = head;
    return newHead;    
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
    // head.printNode();
    // head = reverseList(head);
    // head.printNode();
    head = reverseLLRecur(head);
    head.printNode();
  }
}
