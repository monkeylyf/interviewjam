/**
 * hackerrank_String_Reductions.
 *
 * https://www.hackerrank.com/contests/lambda-calculi-9/challenges/string-reductions
 */


object Solution {

  def main(args: Array[String]) = {
    val xs = io.StdIn.readLine.toList
    println(solve(xs))
  }

  def solve(xs: List[Char]): String = {
    def rec(xs: List[Char], prev: Char, acc: List[Char]): List[Char] = xs match {
      case Nil     => acc
      case x :: xs => rec(xs, x, if (x == prev) acc else x :: acc)
    }

    rec(xs, xs.head, List[Char](xs.head)).reverse.mkString
  }
}
