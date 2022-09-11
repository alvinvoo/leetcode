// problem 409 - Longest Palindrome
import scala.collection.mutable.HashMap
object Solution {
  def longestPalindrome(s: String): Int = 
    // dont need to construct all possibilities, just need to count
    // add up all letter's count that is even
    // take the longest odd count
    val hs = HashMap.empty[Char, Int]
    s.foreach(x => if !hs.contains(x) then hs += (x -> 1)
        else      
          hs += (x -> (hs(x) + 1)))
    var totalEvenCount = 0
    var oddCount = 0
    println(hs)
    hs.values.foreach(v => 
        totalEvenCount += v / 2 * 2
        if v % 2 != 0 then oddCount = 1 
        ) 
    totalEvenCount + oddCount
}


val fail1 = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"

// odd number can add together as well
// so odd count / 2 (as whole number) * 2 = new even count
val fail2 = "bbaaaeebb"
