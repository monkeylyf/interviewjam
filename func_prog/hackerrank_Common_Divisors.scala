/** hackerrank_Common_Divisors.scala
 * https://www.hackerrank.com/contests/lambda-calculi-mar14/challenges/common-divisors
 */



object Solution {
  
  def main(args: Array[String]) {
    val T = readLine().toInt
    for (_ <- 0 until T) {
      val pack = readLine().split(" ")
      val gcd = solve(pack(0).toInt, pack(1).toInt)
      println(numOfDivisors(gcd))
    }
  }

  def solve(a: Int, b: Int): Int = {
    b match {
      case 0 => a
      case _ => solve(b, a % b)
    } 
  }

  def numOfDivisors(a: Int): Int = {
    def rec(a: Int, acc: Int, step: Int, limit: Int): Int = {
      if (step > limit) {
        acc
      } else {
        if (a % step == 0) {
          rec(a, acc + 1, step + 1, limit)  
        } else {
          rec(a, acc, step + 1, limit)  
        }
      }
    }

    rec(a, 0, 1, a)
  }
}
