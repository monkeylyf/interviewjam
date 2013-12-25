/**Evaluating ex
 *hackerrank
 *
 *https://www.hackerrank.com/challenges/eval-ex
 */


object hackerrank_Evaluating_e_X {
  def main(args: Array[String]) {
    println(f(20.00f))
    println(f(5.000f))
    println(f(0.500f))
    println(f(-0.500f))
  }

  /*
   *  Nested Accumulative function use Double to preserve precision.
   *  Using Float directly will fail one test case.
   */
  def f(x: Float): Float = {
    def futil(lvl: Int, x: Double, last: Double): Double = {
      lvl match {
        case 10 => 0 
        case _  => last * x / lvl + futil(lvl + 1, x, last * x / lvl) 
      }
    }
    "%.4f".format(1 + futil(1, x.toDouble, 1.0)).toFloat
  }
}
