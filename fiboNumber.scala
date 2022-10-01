// problem 509 Fibonacci Number
//
object Solution {
  def fib(n: Int): Int = 
    if n == 0 then 0
    else fibIter(n - 1, 0, 1) 
  def fibIter(counter: Int, prev: Int, next: Int): Int =
    if counter == 0 then next
    else
      fibIter(counter - 1, next, prev + next)
}
