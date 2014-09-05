/**
 * hackerrank_Super_Digit.scala
 *
 * https://www.hackerrank.com/contests/lambda-calculi-sep14/challenges/super-digit
 */

object Solution {

  def main(args: Array[String]): Unit = {
    val Array(n, k) = io.StdIn.readLine.split(" +")
    val a = solve(n).toInt
    val b = a * k.toInt
    println(solve(b.toString))
  }

  def solve(n: String): String = n.length match {
    case 1 => n
    case _ => solve(n.toList.map(x => x.asDigit).sum.toString)
  }
}
