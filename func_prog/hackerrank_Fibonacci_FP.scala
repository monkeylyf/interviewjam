/** hackerrank_Fibonacci_FP.scala
 *
 *  https://www.hackerrank.com/challenges/fibonacci-fp
 */



object Solution {
  
  def main(args: Array[String]) = {
    val T = readLine().toInt
    var cache = scala.collection.mutable.Map[Int, Int](0 -> 0, 1 -> 1)

    for (_ <- 0 until T) {
      val n = readLine().toInt
      println(fib(n, cache))
    }
  }

  def fib(n: Int, cache: scala.collection.mutable.Map[Int, Int]): Int = {
    if (!cache.contains(n)) {
      cache += n -> (fib(n - 1, cache) + fib(n - 2, cache)) % 100000007
    }
    cache(n)
  }
}
