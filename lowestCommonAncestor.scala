// problem 235 Lowest Common Ancestor of a Binary Search Tree
// LCA can be solved by solving RMQ then finding the min value in the range
// https://en.wikipedia.org/wiki/Lowest_common_ancestor
// https://en.wikipedia.org/wiki/Range_minimum_query <---
class TreeNode(var value: Int = 0, var left: TreeNode = null, var right: TreeNode = null)

def getPathFromTree(t: TreeNode, p: Int, path: List[Int] = List()): List[Int] = 
  if t == null then List()
  else 
    val newPath = path :+ t.value
    if t.value == p then newPath
    else
      getPathFromTree(t.left, p, newPath) ++ getPathFromTree(t.right, p, newPath) 

// how to convert a tree into a RMQ list
def convertTree(t: TreeNode): List[Int] =
  if t == null then List()
  else
    val cL = convertTree(t.left)
    val cR = convertTree(t.right)
    val ret =  cL ++ List(t.value) ++ cR
    ret

//assuming q tree position is to the RIGHT of p
def LCA(t: TreeNode, p: Int, q: Int): Int =
  val pathForP = getPathFromTree(t, p)
  val pathForQ = getPathFromTree(t, q)

  var i = 0
  var res = 0
  while i < pathForP.length && i < pathForQ.length && pathForP(i) == pathForQ(i) do
    res = pathForP(i)
    i+=1
  res


