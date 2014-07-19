/**
 * hackerrank_Remove_Duplicates.
 *
 * https://www.hackerrank.com/contests/lambda-calculi-jul14/challenges/remove-duplicates
 *
 */



object Solution {

  def main(args: Array[String]): Unit = {
    val s = io.StdIn.readLine
                     .toList
                     .distinct
                     .mkString
    println(s)
  }

  /**
   * Misunderstood the question but still valid code for removing
   * continuous duplicate elements.
   */
  def removeDups(xs: List[Char]): List[Char] = {
    def rec(xs: List[Char], acc: List[Char]): List[Char] = xs match {
      case Nil                      => acc
      case x :: xs if x != acc.head => rec(xs, x :: acc)
      case x :: xs                  => rec(xs, acc)
    }

    rec(xs.tail, List[Char](xs.head)).reverse
  }

}
