/**
 * hackerrank_Swap_Nodes
 *
 * https://www.hackerrank.com/challenges/swap-nodes
 */

import scala.collection.mutable.Queue

object hackerrank_Swap_Nodes {

  def main(args: Array[String]): Unit = {
    val n = scala.io.StdIn.readInt()
    val graph = Array.ofDim[Int](n + 1, 2)
    for (i <- 1 to n) {
      val Array(left, right) = scala.io.StdIn.readLine.split(" ").map(x => x.toInt)
      graph(i)(0) = left
      graph(i)(1) = right
    }

    val root = buildBinaryTree(graph)
  }

  def buildBinaryTree(graph: Array[Array[Int]]): Node = {
    val root = new Node(1)

    val q = new Queue[Int]()
    q.enqueue(1)

    while (!q.isEmpty) {
      val cur = q.dequeue
      println("dar " + cur)
    }


    root
  }

  class Node(value: Int) {
    var left: Node = null
    var right: Node = null

    override def toString = "<" + this.value + ">"
  }

}
