// problem 746 Min Cost Climbing Stairs
object Solution {
  def minCostClimbingStairs(cost: Array[Int]): Int =
    for i <- Range.inclusive(cost.length - 3, 0, -1) do
      cost(i) = Array(cost(i) + cost(i + 1), cost(i) + cost(i + 2)).min
    Array(cost(0),cost(1)).min
}

val tt = Array(10,15,20)
val t2 = Array(1,100,1,1,1,100,1,1,100,1)
