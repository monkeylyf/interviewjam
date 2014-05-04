/** hackerrank_Valid_BST.
 *
 *  https://www.hackerrank.com/challenges/valid-bst
 */




object Solution {
  
  def main(args: Array[String]) = {
    val T = readLine().toInt
    for (t <- 0 until T) {
      val N = readLine().toInt
      val bst = readLine().split(" ").toList.map( x => x.toInt)
      //println(bst)
      isValidBST(bst) match {
        case true => println("YES")
        case false => println("NO")
      }
    }
  }

  def isValidBST(bst: List[Int]): Boolean = {
    if (bst == Nil) {
      true  
    } else {
      val left = bst.filter(_ < bst.head)
      val right = bst.filter(_ > bst.head)
      if (bst.slice(1, left.length + 1) != left) {
        false
      } else if (bst.slice(1 + left.length, bst.length) != right) {
        false
      } else {
        isValidBST(left) && isValidBST(right)
      }
    }
  }
}
