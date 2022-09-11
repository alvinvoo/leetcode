// problem 121 - Best time to Buy and Sell stock
import scala.collection.mutable.ArrayBuffer
object Solution {
  // out of memory
  def maxProfit(prices: Array[Int]): Int = 
    val pricesAb = ArrayBuffer.from(prices.reverse)
    var maxProfit = 0
    for i <- Range(0, prices.length-1) do
      val sP = pricesAb.head
      val pp = pricesAb.dropInPlace(1).fold(0)((acc, bP) =>
          val profit = sP - bP
          if profit > acc then profit else acc)
      if pp > maxProfit then maxProfit = pp
    maxProfit

  // from discussion: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/1735550/Python-Javascript-Easy-solution-with-very-clear-Explanation
  def maxProfit2(prices: Array[Int]): Int =
    var lowerBound = 0
    var upperBound = 1
    var maxProfit = 0
    while upperBound < prices.length do
      val profit = prices(upperBound) - prices(lowerBound)
      if profit < 0 then lowerBound = upperBound
      else if profit > maxProfit then maxProfit = profit

      upperBound += 1
    maxProfit
}
