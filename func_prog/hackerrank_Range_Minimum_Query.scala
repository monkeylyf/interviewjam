/** hackerrank_Range_Minimum_Query
 *
 * https://www.hackerrank.com/challenges/range-minimum-query
 */



object Solution {
  
  def main(args: Array[String]) = {
    val NM = readLine().split(" ").map(x => x.toInt)
   
    val N = NM(0)
    val M = NM(1)

    val arr = readLine().split(" ").map(x => x.toInt)

    val root = construct(arr)

    for (t <- 0 until M) {
      val se = readLine().split(" ").map(x => x.toInt)
      val start = se(0)
      val end = se(1)
      println(query(root, start, end))
    }
  }

  def query(root: Node, s: Int, e: Int): Int = {
    if (s > root.end || e < root.start) {
      Integer.MAX_VALUE  
    } else if (root.start == s && root.end == e) {
      root.min
    } else {
      val mid = root.start + (root.end - root.start) / 2
      mid match {
        case mid if mid >= e => query(root.left, s, e)
        case mid if mid < s  => query(root.right, s, e)
        case _               => math.min(query(root.left, s, mid), query(root.right, mid + 1, e))
      }
    }
  }

  def construct(arr: Array[Int]): Node = {
    def constructUtil(arr: Array[Int], start: Int, end: Int): Node = {
      if (start == end) {
        new Node(arr(start), start, end, null, null)
      } else {
        val mid = start + (end - start) / 2
        val left = constructUtil(arr, start, mid)
        val right = constructUtil(arr, mid + 1, end)

        new Node(math.min(left.min, right.min), start, end, left, right)
      }
    }
    
    constructUtil(arr, 0, arr.length - 1)
  }

  class Node(initMin: Int, initStart: Int, initEnd: Int, initLeft: Node, initRight: Node) {
    
    // Fields.
    val min: Int = initMin

    val start: Int = initStart
    val end: Int = initEnd

    val left: Node = initLeft
    val right: Node = initRight
  }
}

