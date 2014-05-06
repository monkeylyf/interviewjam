/** hackerrank_Number_of_Binary_Search_Tree
 *
 *  https://www.hackerrank.com/challenges/number-of-binary-search-tree
 */




object Solution {
  
  /**
   * Well, it's not really funcional programming style but..
   */
  
  def main(args: Array[String]) = {
    val T = readLine().toInt

    val dp = precompute()

    for (_ <- 0 until T) {
      val N = readLine().toInt  
      println(dp(N))
    }
  }

  def precompute(): Array[Long] = {
    val N = 1000
    val mod = 100000007
    val dp = new Array[Long](N + 1)

    dp(1) = 1
    dp(2) = 2

    for (i <- 3 until N + 1) {
      dp(i) = 2 * dp(i - 1) % mod
      for (j <- 1 until i - 1) {
        dp(i) = (dp(i) + (dp(j) * dp(i - j - 1) % mod)) % mod 
      }
    }

    dp
  }
}
