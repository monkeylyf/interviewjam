/** hackerrank_String_o_Permute
 *
 * https://www.hackerrank.com/contests/lambda-calculi-mar14/challenges/string-o-permute
 */


object Solution {

  def main(args: Array[String]) {
    val T = readLine().toInt
    for (_ <- 0 until T) { 
      println(solve(readLine()))
    }
  }

  def solve(str: String): String = {
    def dfs(x: List[Char], acc: List[Char]): List[Char] = {
      x match {
        case Nil => acc
        case x :: Nil => x :: acc
        case x :: xs  => dfs(xs.tail, x :: xs.head :: acc)
      }   
    }
  
    dfs(str.toList, List())
      .reverse
      .mkString
  }
}
