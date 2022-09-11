// problem 102 - Binary Tree Order Traversal
import scala.collection.mutable.ListBuffer
class TreeNode(var value: Int = 0, var left: TreeNode = null, val right: TreeNode = null)

object Solution {
  def levelOrder(root: TreeNode): List[List[Int]] = 
    if root == null then List()
    else
      val lb = ListBuffer.empty[TreeNode]
      if root.left != null then lb += root.left
      if root.right != null then lb += root.right
      levelOrderIter(List(List(root.value)), lb.toList)

  def levelOrderIter(acc: List[List[Int]], ll: List[TreeNode]): List[List[Int]] =
    if ll.isEmpty then acc
    else
      val lb = ListBuffer.empty[TreeNode]
      val addL = ll.foldLeft(List[Int]())((acc, x) => 
          if x.left != null then lb += x.left
          if x.right != null then lb += x.right
          acc :+ x.value
          )
      levelOrderIter(acc :+ addL, lb.toList)


      // if left == null && right == null then acc
      // else 
      //
      //   val lb = ListBuffer.empty[Int]
      //   val leftL = if root.left != null then lb += root.left.value
      //   val rightL = if root.right != null then lb += root.right.value
      //   levelOrderIter(acc :+ lb.toList, root.left) 
    


  def levelOrderW(root: TreeNode): List[List[Int]] = 
    if root == null then List()
    else
      List(List(root.value)) ++ levelOrder(root.left) ++ levelOrder(root.right)


}

val t1 = TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))
