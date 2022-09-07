// problem 205 Isomorphic Strings
import scala.collection.mutable.Map

object Solution {
  def isIsomorphic(s: String, t: String): Boolean = 
    // first check map, if char in s is found and different from t
    // then false, if not found, add it in
    // Solution only loads once, so need to clear map for everytime test case
    val isoMap: Map[Char, Char] = Map.empty
    def isIsoOne(s: String, t: String): Boolean =
      if s.length == 0 then true
      else 
        val sc = s.head; val tc = t.head
        if isoMap.exists(p => p._1 == sc) then 
          if isoMap(sc) == tc then isIsoOne(s.tail, t.tail)
          else false
        // no 2 characters may map onto itself
        else if isoMap.exists(p => p._2 == tc) then false
        else
          isoMap += ((sc, tc))
          isIsoOne(s.tail, t.tail)
    isIsoOne(s, t)
}
