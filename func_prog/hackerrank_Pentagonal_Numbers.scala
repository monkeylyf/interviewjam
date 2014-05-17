/** hackerrank_Pentagonal_Numbers
 *
 * https://www.hackerrank.com/contests/lambda-calculi-may14/challenges/pentagonal-numbers
 */


object Solution {
  
  def main(args: Array[String]) = {
    val T = readInt
    for (_ <- 0 until T) {
      val n = readInt  
      solve(n)
    }
  }

  def solve(n: Int): Unit = {
    def rec(n: Int , acc: Long): Long = n match {
      case 0 => acc
      case _ => rec(n - 1, acc + 3 * (n - 1) + 1)
    }

    println(rec(n, 0))
  }
}
