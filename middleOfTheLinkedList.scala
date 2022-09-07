// problem 876 Middle of the linked list
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
  def middleNode(head: ListNode): ListNode = 
    val lb = ListBuffer[ListNode]()
    var h = head
    while h != null do
      lb += h
      h = h.next
    lb(math.floor(lb.length/2.0).toInt)
}
