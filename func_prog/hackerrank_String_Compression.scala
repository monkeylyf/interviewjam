/**
 * hackerrank_String_Compression.scala
 *
 * https://www.hackerrank.com/contests/lambda-calculi-sep14/challenges/string-compression
 */


object Solution {

  def main(args: Array[String]): Unit = {
    val s = io.StdIn.readLine.toList
    println(solve(s))
  }

  def solve(xs: List[Char]): String = {
    def rec(xs: List[Char], acc: List[Char], prev: Char, count: Int): String = xs match {
      case x :: xs => if (prev == x) rec(xs, acc, prev, count + 1) else rec(xs, append(acc, prev, count), x, 1)
      case _       => append(acc, prev, count).reverse.mkString
    }

    def reverseNumber(count: Int): List[Char] = count.toString.toList.reverse

    def append(acc: List[Char], prev: Char, count: Int): List[Char] = if (count == 1) prev :: acc else reverseNumber(count) ::: prev :: acc

    rec(xs.tail, List(), xs.head, 1)
  }
}
