/**
 */

object Solution {

  def main(args: Array[String]) {
    val T = io.StdIn.readInt
    val cache = scala.collection.mutable.Map[String, Int]();
    val dice = new Dice(1, 6, 3, 4, 2, 5)
    for (_ <- 0 until T) {
      val NM = io.StdIn.readLine().split(" ").map(x => x.toInt)
      val M = NM(0)
      val N = NM(1)
      println(rec(M, N, cache, dice))
    }
  }

  def rec(M: Int, N: Int, cache: scala.collection.mutable.Map[String, Int], dice: Dice): Int = {
    val key = dice.toString + ":" + M + ":" + N
    //println(key)
    if (cache.contains(key)) {
      return cache(key)
    } else {
      if (M == 1 && N == 1) {
        cache += key -> dice.top
        return dice.top
      } else {
        var max_down = 0
        var max_right = 0
        if (M > 1) {
          max_down = rec(M - 1, N, cache, dice.rotate_down)
        }
        if (N > 1) {
          max_right = rec(M, N - 1, cache, dice.rotate_right)
        }
        var max_point = Math.max(max_down, max_right) + dice.top
        cache += key -> max_point
        return max_point
      }
    }
  }
}


class Dice(t: Int, d: Int, l: Int, r: Int, f: Int, b: Int) {
  val top: Int = t
  val down: Int = d
  val left: Int = l
  val right: Int = r
  val front: Int = f
  val back: Int = b

  def rotate_right(): Dice = new Dice(left, right, down, top, front, back)

  def rotate_down(): Dice = new Dice(back, front, left, right, top, down)

  override def toString(): String = List(top, down, left, right, front, back).mkString(":")
}
