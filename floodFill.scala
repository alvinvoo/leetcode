// problem 733 Flood Fill
//
//
object Solution {
  def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, color: Int, oriColor: Int = -1): Array[Array[Int]] =
    if sr < 0 || sc < 0 || sr >= image.length || sc >= image(0).length || image(sr)(sc) == color then image
    else
      val oriC = if oriColor == -1 then image(sr)(sc) else oriColor
      if image(sr)(sc) == oriC then 
        image(sr)(sc) = color
        floodFill(image, sr - 1, sc, color, oriC)
        floodFill(image, sr, sc - 1, color, oriC)
        floodFill(image, sr + 1, sc, color, oriC)
        floodFill(image, sr, sc + 1, color, oriC)
      else
        image
}
