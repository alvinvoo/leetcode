// problem 278 - First Bad Version
class VersionControl {
  val versions = List(false, false, false, false, true)
  def isBadVersion(version: Int): Boolean =
    // if its n = 5 and bad = 4
    if version >= 4 then true else false
}

object Solution extends VersionControl {
  def firstBadVersion2(n: Int): Int =
    var left = 0
    var right = n
    while left < right do
      val mid = left + ((right - left)/2) // trick to not let INT overflow
      if isBadVersion(mid) then
        right = mid
      else
        left = mid + 1
    left
        



  def firstBadVersion(n: Int): Int =
    if n == 1 then 1 
    else 
      versionIter(1, n)

  def versionIter(loB: Int, hiB: Int, prevVersion: Boolean = true): Int =
    if loB == 1 && hiB == 1 then 1
    else
     println(s"loB $loB hiB $hiB prevVersion $prevVersion")
     // targetInd = (loB + hiB) / 2
     // stop conditions: 
     //  - if previous true, if this v is false && targetInd = hiB - 1, then return hiB
     //  - if previous false, if this v is true && targetInd = loB + 1, then return loB 
     //  else
     // if v is false, continue (targetInd + hiB) / 2
     // if v is true, continue (1 + targetInd) / 2
     val targetInd = if loB == 1 then math.floor((loB + hiB) / 2.0).toInt
                                 else math.ceil((loB + hiB) / 2.0).toInt
     val v = isBadVersion(targetInd)

     if v then
       if !prevVersion && targetInd == loB + 1 then targetInd 
       else 
         versionIter(1, targetInd, v)
     else 
       if prevVersion && targetInd == hiB - 1 then hiB 
       else 
         versionIter(targetInd, hiB, v)
}


