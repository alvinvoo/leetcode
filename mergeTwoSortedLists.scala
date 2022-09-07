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
  def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode =
    if list1 ==  null then list2
    else if list2 == null then list1
    else
      var retList = ListNode(-1)
      var l1 = list1
      var lN = list2
      while l1 != null && lN != null do
        if l1.x <= lN.x then
          if retList.x == -1 then retList = ListNode(l1.x, null)
          else retList = appendToListNode(retList, ListNode(l1.x, null)) 
          l1 = l1.next
        else
          if retList.x == -1 then retList = ListNode(lN.x, null)
          else retList = appendToListNode(retList, ListNode(lN.x, null)) 
          lN = lN.next
      if lN != null then appendToListNode(retList, lN)
      else appendToListNode(retList, l1)
  def appendToListNode(l1: ListNode, l2: ListNode): ListNode =
    if l1 == null then l2
    else 
      l1.next = appendToListNode(l1.next, l2)
      l1

  // from neetcode
  def mergeTwoList2(list1: ListNode, list2: ListNode): ListNode =
    val dummy = ListNode() // this will have same reference as tail below... so just need to return this at the end
    // a common technique to use a dummy node at start
    var tail = dummy
    var l1 = list1
    var lN = list2
    while l1 != null && lN != null do
      if l1.x <= lN.x then
        tail.next = ListNode(l1.x)
        l1 = l1.next
      else
        tail.next = ListNode(lN.x)
        lN = lN.next
      tail = tail.next
    if lN != null then tail.next = lN
    else tail.next = l1

    dummy.next
}

