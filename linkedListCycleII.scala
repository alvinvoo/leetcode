// problem 142 - Linked List Cycle II
import scala.collection.mutable.{ListBuffer, HashMap}
class ListNode(var x: Int = 0, var next: ListNode = null) {
}

object ListNode {
  def toList(l: ListNode): List[Int] =
    val lb = ListBuffer.empty[Int]
    var li = l
    while li != null do 
      lb += li.x
      li = li.next
    lb.toList
}

object Solution {
  def detectCycle(head: ListNode): ListNode =
    if head == null then null 
    else 
      val nP = HashMap[ListNode, ListNode | Null](head -> null)
      var ans: ListNode | Null = null
      var prev = head
      var next = head.next
      while next != null && ans == null do
        if !nP.contains(next) then
          nP += (next -> prev)
        else
          ans = next
        prev = prev.next
        next = next.next
      ans
}

val ll = ListNode(2, ListNode(0, ListNode(4)))
ll.next.next.next = ll
val rr = ListNode(3, ll)

val l2 = ListNode(1, ListNode(2))
l2.next.next = l2

val l3 = ListNode(1)

