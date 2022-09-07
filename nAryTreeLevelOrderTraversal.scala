import scala.collection.mutable.ListBuffer
class Node(var value: Int, var children: List[Node] = List()) 

object Solution {
  def levelOrder(root: Node): List[List[Int]] =
    if root.children.isEmpty then List(List(root.value))
    else List(List(root.value)) ++ childLevels(root)

  def childLevels(root: Node): List[List[Int]] =
    if root.children.isEmpty then List()
    else
      val lb = ListBuffer.empty[Node]
      val c = root.children.foldLeft(List[Int]())((acc, x) => {
        // if x has children, must somehow recurse and mash the childrens together
        lb += x
        acc :+ x.value
      })
      List(c) ++ lb.flatMap(childLevels) 
}


val n2 = Node(1, 
          List(Node(2), Node(3, 
                          List(Node(6), Node(7))
                            ), Node(4), Node(5, List(Node(9), Node(10)))
              )
             )

// if away from 2 branches seems no good
[1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]

output
[[1],[2,3,4,5],[6,7],[11],[14],[8],[12],[9,10],[13]]

expected
[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
