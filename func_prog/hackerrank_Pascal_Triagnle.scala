/*hackerrank_Pascal_Triagnle
hackerrank

https://www.hackerrank.com/challenges/pascals-triangle
*/

object hackerrank_Pascal_Triagnle {
  
  def main(args: Array[String]) = {
    f(4)     
  } 

  def f(n: Int) = {
    def futil(lvl: Int, index: Int): Int = {
      index match {
        case 0 => 1
        case index if index == lvl - 1 => 1
        case _ => futil(lvl - 1, index) + futil(lvl - 1, index - 1)
      }  
    }
    for (lvl <- 1 until n + 1) {
      for (index <- 0 until lvl) {
        printf(futil(lvl, index) + " ")
      }
      println()
    }
  }

}
