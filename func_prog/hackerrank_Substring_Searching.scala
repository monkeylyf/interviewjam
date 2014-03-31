/** tringmatchingmat** hackerrank_Substring_Searching.
 *
 * https://www.hackerrank.com/contests/lambda-calculi-mar14/challenges/kmp-fp
 */


object hackerrank_Substring_Searching {

  def main(args: Array[String]) {
    val T = readLine().toInt
    for (_ <- 0 until T) {
      val text = readLine()
      val pat = readLine()

      if (KMP(text, pat)) {
        println("YES")
      } else {
        println("NO")
      }
    }
  }

  def KMP(text: String, pat: String): Boolean = {
    var i = 0
    var j = 0

    val overlay = new Array[Int](pat.length)
    overlay(0) = -1

    for (i <- 1 until pat.length) {
      var idx = overlay(i - 1)
      while (idx >= 0 && pat(i) != pat(idx + 1)) {
        idx = overlay(idx)
      }
      if (pat(i) == pat(idx + 1)) {
        overlay(i) = idx + 1
      } else {
        overlay(i) = -1
      }
    }

    i = 0
    while (i < text.length && j < pat.length) {
      if (text(i) == pat(j)) {
        i += 1
        j += 1
      } else if (j == 0) {
        i += 1
      } else {
        j = overlay(j - 1) + 1
      }
    }

    j == pat.length
  }
} 
