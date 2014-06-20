/**
 * https://www.hackerrank.com/contests/lambda-calculi-jun14/challenges/rotate-string
 *
 */


object Solution {
  def main(args: Array[String]) {
    val T = scala.io.StdIn.readInt()
    for (_ <- 0 until T) {
      rotate(scala.io.StdIn.readLine())
    }
  }

  def rotate(s: String) {
    def dfs(xs: List[Char], acc: List[String]): Unit = acc.size match {
      case len if len == s.size => println(acc.reverse.mkString(" "))
      case _                    => val ss = xs.drop(1) ::: xs.take(1); dfs(ss, ss.mkString :: acc);
    }

    dfs(s.toList, List[String]())
  }
}
