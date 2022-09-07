object Solution {
  def isSubsequence(s: String, t: String): Boolean =
    if s.length == 0 then true
    else 
      val tt = t.dropWhile(_!=s.head)
      if tt.length == 0 then false
      else 
        isSubsequence(s.tail, tt.tail)
}
