// problem 98 Validate Binary Search Tree
class TreeNode(var value: Int = 0, var left: TreeNode = null, var right: TreeNode = null)

object Solution {
  // naive and wrong
  def isValidBST(root: TreeNode): Boolean = 
    if root == null || (root.left == null && root.right == null) then true
    else
      var e: Boolean = true 
      if root.left != null then
        e = e && (root.value > root.left.value)
      if root.right != null then 
        e = e && (root.value < root.right.value)

      e && isValidBST(root.left) && isValidBST(root.right)

  def isValidBST2(root: TreeNode, l: TreeNode = null, r: TreeNode = null): Boolean =
    if root == null then true
    else if l != null && root.value <= l.value then false
    else if r != null && root.value >= r.value then false
    else
      return isValidBST2(root.left, l, root) && isValidBST2(root.right, root, r)
}
