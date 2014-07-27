/**
 * hackerrank_John_And_Fences.
 *
 * https://www.hackerrank.com/contests/lambda-calculi-jul14/challenges/john-and-fences
 *
 */

import scala.collection.mutable.Stack

object Solution {

  def main(args: Array[String]): Unit = {
    val n = io.StdIn.readLine.toInt
    val height = io.StdIn.readLine.split(" +").map(_.toInt)
    solve(n, height)
  }

  def solve(n: Int, height: Array[Int]): Unit = {
    val idx = Stack[Int]()
    val hgt = Stack[Int]()

    var ret = 0L
    var lastIdx = 0
    var lastHieght = 0

    for (i <- 0 until n) {
      // Monotone increasing stack when it's empty or current height
      // is larger than the previous.
      if (hgt.isEmpty || hgt.head < height(i)) {
        hgt.push(height(i))
        idx.push(i)
      } else if (hgt.head > height(i)) {
        while (!hgt.isEmpty && hgt.head > height(i)) {
          // Find all previous fences whose heights are less than height(i)
          // and calc their max rectangle area.
          lastIdx = idx.pop
          lastHieght = hgt.pop
          ret = Math.max(ret, lastHieght * (i - lastIdx))
        }
        hgt.push(height(i))
        idx.push(lastIdx)
      }
      // Do not care about current height is equal to previous since
      // their range min value are identical.
      // No else condition.
    }

    while (!hgt.isEmpty) {
      ret = Math.max(ret, hgt.pop * (n - idx.pop))
    }

    println(ret)
  }
}
