import scala.collection.mutable.Stack
class Node(var value: Int, var children: List[Node] = List())

object Solution{
  def preorder(root: Node): List[Int] = 
    if root == null then List()
    else
      List(root.value) ++ root.children.flatMap(preorder(_))

  def preorder2(root: Node): List[Int] =
    if root == null then List()
    else 
      preorder2Iter(List(root.value), Stack((root, 0)))
    

  def preorder2Iter(acc: List[Int], parentStack: Stack[(Node, Int)] = Stack.empty): List[Int] =
    if parentStack.isEmpty then
      acc
    else
// probably need a stack (LIFO) that keeps track of the cur processing node + childInd
// (Node, chidIndUnderProcess)
      val (parentNode, childInd) = parentStack.head
      val children = parentNode.children
      if childInd + 1 > children.length then // this children list is finished traversed 
        parentStack.pop()
        preorder2Iter(acc, parentStack)
      else
        val childNode = children(childInd)
        parentStack(0) = (parentNode, childInd + 1)
        if !childNode.children.isEmpty then
          preorder2Iter(acc :+ childNode.value, parentStack.push((childNode, 0)))
        else
          preorder2Iter(acc :+ childNode.value, parentStack)
}

val r1 = Node(1, List(Node(3, List(Node(5), Node(6))), Node(2), Node(4)))
