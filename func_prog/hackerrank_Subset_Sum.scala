/** hackerrank_Subset_Sum.
 *  
 *  https://www.hackerrank.com/contests/lambda-calculi-apr14/challenges/subset-sum
 */


object Solution {

  def main(args:Array[String]) = {
    val T = readLine().toInt
    val arr = readLine().split(" ").map(_.toInt).sortWith(_ > _).toList
    println(arr)
    val N = readLine().toInt
    for (_ <- 0 until N) {
      val sum = readLine().toLong
      println(sum)
      println(binarySearch(toAccArray(arr), T, sum))
    }
  }

  /** O(lgn) but not really that funtional programming...
   */
  def binarySearch(arr: Array[Long], length: Int, sum: Long): Int = {
    var head = 0
    var tail = length - 1
    while (head <= tail) {
      val mid = head + (tail - head) / 2
      if (arr(mid) == sum) {
        return mid + 1
      } else if (arr(mid) < sum) {
        head = mid + 1
      } else {
        tail = mid - 1
      }
    }
    if (head == length) {
      return -1
    } else {
      return head + 1  
    }
  }

  def toAccArray(xs: List[Int]): Array[Long] = {
    def rec(xs: List[Int], acc: List[Long], aggr: Long): List[Long] = xs match {
      case Nil =>  acc
      case x :: xs  => rec(xs, (x + aggr) :: acc, aggr + x)
    }

    rec(xs, List(), 0L).reverse.toArray
  }

  /** O(n) TLE.
   */
  def minSize(xs: List[Int], sum: Long): Int = {
    def rec(xs: List[Int], sum: Long, count: Int): Int = sum match {
      case sum if sum <= 0 => count
      case _ => rec(xs.tail, sum - xs.head, count + 1)
    }

    rec(xs, sum, 0)
  }
}
