/**
 * hackerrank_Prefix_Compression
 *
 * https://www.hackerrank.com/contests/lambda-calculi-oct14/challenges/prefix-compression
 */


object Solution {

  def main(args: Array[String]): Unit = {
    val a = io.StdIn.readLine
    val b = io.StdIn.readLine
    val prefixLength = rec(a.toList, b.toList, 0)
    println(prefixLength + " " + a.substring(0, prefixLength))
    println((a.length - prefixLength) + " " + a.substring(prefixLength, a.length))
    println((b.length - prefixLength) + " " + b.substring(prefixLength, b.length))
  }

  def rec(a: List[Char], b: List[Char], count: Int): Int = {
    if (a.isEmpty || b.isEmpty || a.head != b.head) {
      count
    } else {
      rec(a.tail, b.tail, count + 1)
    }
  }
}
