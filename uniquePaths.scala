//problem 62 Unique Paths
import scala.collection.mutable.HashMap
object Solution {
  def uniquePaths(m: Int, n: Int, memo: HashMap[(Int,Int), Int] = HashMap.empty): Int =
    if m == 1 && n == 1 then 1
    else if m == 0 || n == 0 then 0
    else
      if memo.contains((m,n)) then memo((m,n))
      else
        val r = uniquePaths(m - 1, n, memo) + uniquePaths(m , n - 1, memo)
        memo.addOne(((m,n), r))
        r
}
