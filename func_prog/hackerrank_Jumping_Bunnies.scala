/** hackerrank_Jumping_Bunnies
 *
 *  https://www.hackerrank.com/contests/lambda-calculi-apr14/challenges/jumping-bunnies
 */





object hackerrank_Jumping_Bunnies {
  
  def main(args: Array[String]) {
    val N = readLine()
    val line = readLine()
    val xs = line.split(" ").toList

    //println(lcm(8, 4))
    //println(lcm(4, 8))
    //println(lcm(2, 6))
    //println(lcm(8, 12))
    //println(lcm(0, 0))
    //println(xs)
    println(lcmList(xs.map(_.toInt)))
  }

  def lcmList(xs: List[Int]): Long = xs match {
    case x :: Nil => x
    case x :: xs => lcm(x, lcmList(xs))
  }

  def lcm(a: Long, b: Long): Long = {
    val gcdVal = gcd(a, b)
    gcdVal match {
      case 0 => 0
      case _ => a * b / gcdVal
    }
  }

  def gcd(a: Long, b: Long): Long = b match {
    case 0 => a
    case _ => gcd(b, a % b)
  }
}
