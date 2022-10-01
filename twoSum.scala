// problem 1 Two Sum
// // twoSum(nums.tail, target - nums.head, indArr :+ nums.head)
object Solution {
  def twoSum(nums:Array[Int], target: Int) =
    twoSumIter(nums.zipWithIndex, target)

  def twoSumIter(nums: Array[(Int, Int)], target: Int, indArr: Array[Int] = Array.empty): Array[Int] =
    if target == 0 && !indArr.isEmpty then indArr
    else if nums.isEmpty then Array() 
    else
      val yy = for i <- Range(0, nums.length) yield
        twoSumIter(nums.slice(i + 1, nums.length), target - nums(i)._1, indArr :+ nums(i)._2)
      yy.fold(Array.empty[Int])(_ ++ _)
}

// why so complicated? :) 
object Solution2 {
  def twoSum(nums:Array[Int], target: Int) =
    twoSumIter(nums.zipWithIndex, target)

  def twoSumIter(nums: Array[(Int, Int)], target: Int, indArr: Array[Int] = Array.empty, iter: Int = 0): Array[Int] =
    if iter == 2 then
      if target == 0 then indArr
      else Array()
    else
      val yy = for i <- Range(0, nums.length) yield
        val t = target - nums(i)._1
        twoSumIter(nums.slice(i + 1, nums.length), t, indArr :+ nums(i)._2 , iter + 1)
      yy.fold(Array.empty[Int])(_ ++ _)
}

import scala.collection.mutable.ListBuffer
object Solution3 {
  def twoSum(nums: Array[Int], target: Int): Array[Int] =
    val lb = ListBuffer.empty[Int]
    var start = 0
    var end = 1
    while lb.length < 2 do
      if nums(start) + nums(end) == target then 
        lb.addOne(start).addOne(end)
      else if end + 1 == nums.length then
        start += 1
        end = start + 1
      else
        end += 1
    lb.toArray
}
