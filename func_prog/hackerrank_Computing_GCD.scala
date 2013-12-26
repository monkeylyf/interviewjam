/*hackerrank_Computing_GCD
hackerrank

https://www.hackerrank.com/challenges/functional-programming-warmups-in-recursion---gcd
*/


object hackerrank_Computing_GCD {
  
  def main(args: Array[String]) {
    println(gcd(57, 24))   
  }

  // To return the value of the GCD of x and y
  def gcd(x: Int, y: Int): Int = {
    y match {
      case 0 => x
      case _ => gcd(y, x % y)
    }        
  }
}
