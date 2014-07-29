/**
 * hackerrank_Sherlock_And_The_Maze.
 *
 * https://www.hackerrank.com/contests/lambda-calculi-jul14/challenges/sherlock-and-the-maze
 */

object Solution {

  private val mod = 1000000007
  private val delim = " "

  def main(args: Array[String]): Unit = {
    val T = io.StdIn.readLine.toInt
    val cache = scala.collection.mutable.Map[String, Integer]()
    val dpStatus = dp()
    for (_ <- 0 until T) {
      val Array(n, m, k) = io.StdIn.readLine.split(" +").map(_.toInt)
      //println(if (n == 1 && m == 1) 1 else solve(n, m, k, cache))
      println(if (n == 1 && m == 1) 1
              else (dpStatus(n)(m)(k)(0) + dpStatus(n)(m)(k)(1)) % mod)
    }

  }

  /**
   * Pure dynamic programming approach.
   */
  def dp(): Array[Array[Array[Array[Int]]]] = {
    val n = 100
    val m = 100
    val k = 100
    val dp = Array.fill(n + 1, m + 1, k + 1, 2)(0)

    // Init dp states.
    for (i <- 1 to n; kk <- 0 to k) {
      dp(i)(1)(kk)(0) = 1
      dp(1)(i)(kk)(1) = 1
    }

    for {
      i  <- 2 to n
      j  <- 2 to m
      kk <- 0 to k
    } {
      // Carry-on
      dp(i)(j)(kk)(0) = dp(i - 1)(j)(kk)(0)
      dp(i)(j)(kk)(1) = dp(i)(j - 1)(kk)(1)

      // Make down turn if k > 0
      if (kk > 0) {
        dp(i)(j)(kk)(0) = (dp(i)(j)(kk)(0) + dp(i - 1)(j)(kk - 1)(1)) % mod
      }

      // Make right turn if k > 0
      if (kk > 0) {
        dp(i)(j)(kk)(1) = (dp(i)(j)(kk)(1) + dp(i)(j - 1)(kk - 1)(0)) % mod
      }
    }

    return dp
  }

  /**
   * case prev 1 turn right
   * case prev 0 turn down
   * Pending: Failed on test case #5: TLE
   */
  def solve(i: Int, j: Int, k: Int, cache: scala.collection.mutable.Map[String, Integer]): Int = {
    def rec(i: Int, j: Int, k: Int, prev: Int): Int = {
      if (i <= 0 || j <= 0 || k < 0) {
        return 0
      } else if (i == 1 && j == 1) {
        return 1
      }

      val cacheKey = mkKey(i, j, k, prev)
      if (!cache.contains(cacheKey)) {
        lazy val value = (rec(i - 1, j, if (prev == 0) k else k - 1, 0) +
                          rec(i, j - 1, if (prev == 1) k else k - 1, 1)) % mod
        cache += cacheKey -> value
      }

      return cache(cacheKey)
    }

    (rec(i - 1, j, k, 0) + rec(i, j - 1, k, 1)) % mod
  }

  /**
   * Construct cache key.
   */
  def mkKey(i: Int, j: Int, k: Int, prev: Int): String = List(i, j, k, prev).mkString(delim)

}
