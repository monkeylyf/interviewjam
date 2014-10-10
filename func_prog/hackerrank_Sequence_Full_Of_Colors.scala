/**
  * hackerrank_Sequence_Full_Of_Colors
  *
  * https://www.hackerrank.com/contests/lambda-calculi-oct14/challenges/sequence-full-of-colors
  */



object Solution {

  def main(args: Array[String]): Unit = {
    val t = io.StdIn.readInt
    for (_ <- 0 until t) {
      val seq = io.StdIn.readLine
      println(if (solve(seq.toList, 0, 0, 0, 0)) "True" else "False")
    }
  }

  def prefixCondition(r: Int, g: Int, y: Int, b: Int): Boolean = Math.abs(r - g) <= 1 && Math.abs(y - b) <= 1

  def exitCondition(r: Int, g: Int, y: Int, b: Int): Boolean = r == g && y == b

  def solve(xs: List[Char], r: Int, g: Int, y: Int, b: Int): Boolean = xs match {
    case 'R' :: xs => if (prefixCondition(r + 1, g, y, b)) solve(xs, r + 1, g, y, b) else false
    case 'G' :: xs => if (prefixCondition(r, g + 1, y, b)) solve(xs, r, g + 1, y, b) else false
    case 'Y' :: xs => if (prefixCondition(r, g, y + 1, b)) solve(xs, r, g, y + 1, b) else false
    case 'B' :: xs => if (prefixCondition(r, g, y, b + 1)) solve(xs, r, g, y, b + 1) else false
    case _         => exitCondition(r, g, y, b)
  }

}
