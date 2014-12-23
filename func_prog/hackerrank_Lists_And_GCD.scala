/**
 * hackerrank_Lists_And_GCD.
 *
 * https://www.hackerrank.com/contests/lambda-calculi-9/challenges/lists-and-gcd
 */


object Solution {

  def main(args: Array[String]) = {
    val q = io.StdIn.readLine.toInt
    var common = List[Int]()
    for (i <- 0 until q) {
      val repr = io.StdIn.readLine.split(" ").map(_.toInt).toList
      if (i == 0) {
        common = repr
      } else {
        common = commonOfTwoLists(common, repr)
      }
    }

    println(common.mkString(" "))
  }

  /**
   * Basically the idea is to find the common element in two list.
   */
  def commonOfTwoLists(a: List[Int], b: List[Int]): List[Int] = {
    def rec(a: List[Int], b: List[Int], acc: List[Int]): List[Int] = {
      if (a == Nil || b == Nil) {
        return acc
      } else {
        val a_num = a.head
        val a_count = a.tail.head
        val b_num = b.head
        val b_count = b.tail.head
        if (a_num == b_num) {
          return rec(a.tail.tail, b.tail.tail, Math.min(a_count, b_count) :: a_num :: acc)
        } else if (a_num > b_num) {
          return rec(a, b.tail.tail, acc)
        } else {
          return rec(a.tail.tail, b, acc)
        }
      }
    }

    rec(a, b, List[Int]()).reverse
  }
}
