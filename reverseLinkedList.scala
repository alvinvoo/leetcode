// problem 206 - reverse linked list
import scala.collection.mutable.ListBuffer
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
  def reverseList(head: ListNode): ListNode = 
    val lb = ListBuffer.empty[Int]
    var h = head
    while h != null do
      lb += h.x
      h = h.next 
    val dummy = ListNode()
    var tail = dummy
    for l <- lb.reverse do
      tail.next = ListNode(l)
      tail = tail.next

    dummy.next
}
