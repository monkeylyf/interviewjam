/**
 * https://www.hackerrank.com/contests/lambda-calculi-jun14/challenges/mango
 */


object Solution {
  def main(args: Array[String]) = {
    val Array(n, m) = io.StdIn.readLine.split(" +").map(_.toLong)
    val appetite = io.StdIn.readLine.split(" +").map(_.toInt)
    val factor   = io.StdIn.readLine.split(" +").map(_.toInt)
    println(solve(appetite, factor, m))
  }

  def solve(appetite: Array[Int], factor: Array[Int], m: Long): Long = {
    var head = 0L
    var tail = appetite.size.toLong
    while (head < tail) {
      val mid = (tail - head + 1) / 2 + head
      val sum = (appetite, factor)
                .zipped
                .map(_ + (mid - 1) * _)
                .sortWith(_ < _)
                .take(mid.toInt)
                .foldLeft(0L)(_ + _)
      if (sum > m) {
        tail = mid - 1  
      } else {
        head = mid
      }
    }
    return head
  }
}
