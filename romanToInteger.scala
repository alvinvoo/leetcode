// question 13: https://leetcode.com/problems/roman-to-integer 
object Solution {
  val romanMap = Map(
    'I' -> 1, 
    'V' -> 5,
    'X' -> 10,
    'L' -> 50,
    'C' -> 100,
    'D' -> 500,
    'M' -> 1000,
  )
  def romanToInt(s: String): Int = 
    var total = 0
    var beforeChar: Char = 0
    // add up the char starting from the right
    for si <- s.reverse.iterator do
      // unless encounter the 6 special subtraction conditions
      si match 
        case 'I' if beforeChar == 'V' || beforeChar == 'X' => total -= romanMap(si)
        case 'X' if beforeChar == 'L' || beforeChar == 'C' => total -= romanMap(si)
        case 'C' if beforeChar == 'D' || beforeChar == 'M' => total -= romanMap(si)
        case _ => total += romanMap(si)
      beforeChar = si
    total
}
