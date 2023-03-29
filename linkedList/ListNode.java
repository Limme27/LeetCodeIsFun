package linkedList;

public class ListNode {
  int val;
  public ListNode next;
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
