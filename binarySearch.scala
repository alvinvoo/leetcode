object Solution {
  def search(nums: Array[Int], target: Int): Int = 
    if nums.isEmpty then -1
    else if nums.length == 1 then 
      if nums(0) == target then 0 else -1
    else
     val upInd = nums.length/2
     val loInd = upInd - 1

     val (loHalf, upHalf) = (nums.slice(0, loInd), nums.slice(upInd + 1, nums.length))

     if target == nums(upInd) then upInd
     else if target > nums(upInd) then 
      val s = search(upHalf, target)
      if s == -1 then -1 
      else upInd + 1 + s
     else if target == nums(loInd) then loInd
     else if target < nums(loInd) then 
      val s = search(loHalf, target)
      if s == -1 then -1 
      else s
     else -1
}

val t = Array(-1, 0, 3, 5, 9, 12)
