import scala.collection.mutable.HashMap
object Solution {
  def climbStairs(n: Int, m: HashMap[Int, Int] = HashMap.empty): Int =
    if n < 0 then 0
    else if n == 0 then 1
    else 
      if m.contains(n) then m(n)
      else
        val n2 = climbStairs(n - 2, m) + climbStairs(n - 1, m)
        m.addOne((n, n2))
        n2
}
