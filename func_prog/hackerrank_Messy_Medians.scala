/**
 * hackerrank_Messy_Medians.
 *
 * https://www.hackerrank.com/contests/lambda-calculi-jul14/challenges/messy-medians
 */

import scala.collection.immutable.TreeSet


/**
 * Courtesy of ssartech for the concise and functional solution.
 */
object Solution {
  def main(args: Array[String]): Unit = {
    val t = io.StdIn.readLine.toInt
    val fac = 1000000L

    (1 to t).foldLeft(IndexedSeq(new TreeSet[Long]())) { (acc, i) =>
      val streamInValue = io.StdIn.readLine.toLong
      val set = if (streamInValue >= 0) {
        // Using fac to mix value with index so duplicate input value
        // will not be overwritten in TreeSet.
        acc.last + (fac * streamInValue + i)
      } else {
        // Request to roll back. Substract by length.
        acc(acc.length + streamInValue.toInt)
      }
      println(getMedian(set) / fac)
      // Return updated new TreeSet.
      acc :+ set
    }
  }

  def getMedian(ts: TreeSet[Long]): Long = {
    val medianIdx = (ts.size - 1) / 2
    ts.slice(medianIdx, medianIdx + 1).head
  }
}
