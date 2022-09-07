// problem 1480: https://leetcode.com/problems/running-sum-of-1d-array/
//
object Solution {
  def runningSum(nums: Array[Int]): Array[Int] =
    for i <- Range(1, nums.length) do
      val nVal = nums(i) + nums(i-1)
      nums(i) = nVal
    nums
}
