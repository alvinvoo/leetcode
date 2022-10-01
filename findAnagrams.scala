// problem 438 Find all anagrams in a string
import scala.collection.mutable.{ ListBuffer, HashMap }

// object Solution {
//   val memo = HashMap.empty[(String, String), Boolean]
//   def isAnagram(s: String, p: String): Boolean =
//     s.intersect(p).length == s.length
//
//   def isAnagramEfi(s: String, p: String): Boolean =
//     if memo.contains((s,p)) then memo((s,p))
//     else
//       val r = s.sorted(Ordering.Char) == p.sorted(Ordering.Char)
//       memo.addOne(((s,p), r))
//       r
//
//   def findAnagrams(s: String, p: String): List[Int] = 
//     if p.length > s.length then List()
//     else
//       s.sliding(p.length, 1).zipWithIndex.foldLeft(List[Int]())((acc,i) => if isAnagram(i._1, p) then acc :+ i._2 else acc)
//
//   // still MLE.. too bad
//   def findAnagramsEfi(s: String, p: String): List[Int] =
//     if p.length > s.length then List()
//     else
//       val allCombi = s.sliding(p.length, 1).toList
//       val lb = ListBuffer.empty[Int]
//       for i <- Range(0, allCombi.length) do
//         if isAnagramEfi(allCombi(i), p) then lb.addOne(i)
//       lb.toList
// }

val s = "aaaaaaaaaa"
val p = "aaaaaaaaaaaaa"

val s1 = "cbaebabacd"
val p1 = "abc"

var s2 = ""
var ii = 0
while ii < 20001 do
  s2 :+= 'a'
  ii += 1

var p2 = ""
ii = 0
while ii < 10000 do
  p2 :+= 'a'
  ii += 1

object Solution2 {
  def same(s: ListBuffer[Int], p: ListBuffer[Int]): Boolean =
    var i = 0
    while i < 26 && p(i) == s(i) do
      i += 1
    i == 26 // if all same, then should be until the end of array

  def freq(s: String): ListBuffer[Int] =
    val l = ListBuffer.fill(26)(0)
    for si <- s do
      l(si - 'a') += 1
    l

  // idea: to use a fixed 26 characters Array
  def findAnagrams(s: String, p: String): List[Int] =
    val lb = ListBuffer.empty[Int]
    if p.length > s.length then lb.toList
    else
      val sL = s.length
      val pL = p.length
      val sFreqLb = freq(s.slice(0, pL))
      val pFreqLb = freq(p) // wont change

      if same(sFreqLb, pFreqLb) then lb.addOne(0)

      for i <- Range(pL, sL) do
        sFreqLb(s(i - pL) - 'a') -= 1
        sFreqLb(s(i) - 'a') += 1
        if same(sFreqLb, pFreqLb) then lb.addOne(i - pL + 1)

      lb.toList
}
