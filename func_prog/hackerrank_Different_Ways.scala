/** hackerrank_Different_Ways
 *
 *  https://www.hackerrank.com/challenges/different-ways-fp
 */



object Solution {
  
  def main(args: Array[String]) = {
    val T = readLine().toInt
    var cache = scala.collection.mutable.Map[String, Int]()
    for (_ <- 0 until T) {
      val NK = readLine().split(" ").map(x => x.toInt)
      val N = NK(0)
      val K = NK(1)

      println(combination(N, K, cache))
    }
    
  }

  def combination(N: Int, K: Int, cache: scala.collection.mutable.Map[String, Int]): Int = {
    val key = N + ":" + K
    if (K == 0 || N == K) {
      cache += (key -> 1)  
    } else if (!cache.contains(key)) {
      cache += (key -> (combination(N - 1, K - 1, cache) + combination(N - 1, K, cache)) % 100000007)
    }
    cache(key)
  }
}
