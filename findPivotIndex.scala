// problem 724 - Find Pivot Index
//
object Solution {
  def runningSums(nums: Array[Int]): Array[Int] =
    for i <- Range(1, nums.length) do
      val newVal = nums(i) + nums(i - 1)
      nums(i) = newVal
    nums

  def pivotIndex(nums: Array[Int]): Int = 
    val rNums = runningSums(nums)
    var ret = -1
    for i <- Range(0, rNums.length) do
      println(s"evaluating $i")
      val leftSum = if i == 0 then 0 else rNums(i-1) 
      val rightSum = if i == rNums.length - 1 then 0 else rNums(rNums.length - 1) - rNums(i)
      if leftSum == rightSum then ret = i
    ret
  def pivotIndex2(nums:Array[Int]): Int =
    val rNums = runningSums(nums)
    def pivotOne(i: Int = 0): Int =
      if i >= rNums.length then -1 
      else 
        val leftSum = if i == 0 then 0 else rNums(i-1) 
        val rightSum = if i == rNums.length - 1 then 0 else rNums(rNums.length - 1) - rNums(i)
        if leftSum == rightSum then i
        else
          pivotOne(i + 1)
    pivotOne()
}
