/** hackerrank_The_Sum_Of_Powers
 *
 *  https://www.hackerrank.com/challenges/functional-programming-the-sums-of-powers
 */


object Solution {
  
  def main(args: Array[String]) = {
    val X = readLine().toInt
    val N = readLine().toInt
    println(sumOfPowers(X, N))
  }

  def sumOfPowers(X: Int, N: Int): Int = {
    def rec(X: Int, N: Int, step: Int): Int = X match {
      case X if X < math.pow(step, N).toInt => 0
      case X if X == math.pow(step, N).toInt => 1
      case _ => rec(X - math.pow(step, N).toInt, N, step + 1) + rec(X, N, step + 1)
    }
    
    rec(X, N, 1)
  }
}
