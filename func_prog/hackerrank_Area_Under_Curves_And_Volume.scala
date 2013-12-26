/*Area Under Curves and Volume of Revolving a Curve
hackerrank

https://www.hackerrank.com/challenges/area-under-curves-and-volume-of-revolving-a-curv
*/


object hackerrank_Area_Under_Curves_And_Volume {
  
  def main(args: Array[String]) {
    var coefficients = List(1, 2, 3, 4, 5)
    var powers = List(6, 7, 8, 9, 10)
    println(summation(f, 4, 1, coefficients, powers))
    println(summation(area, 4, 1, coefficients, powers))
    
    coefficients = List(1, 2)
    powers = List(0, 1)
    println(summation(f, 20, 2, coefficients, powers))
    println(summation(area, 20, 2, coefficients, powers))
  }  

  // This function will be used while invoking "Summation" to compute
  // The area under the curve.
  def f(coefficients: List[Int], powers: List[Int], x: Double): Double = {
    // To compute the value of the function
    // For the given coefficients, powers and value of x
    def fUtil(coefficients: List[Int], powers: List[Int], x: Double, acc: Double): Double = {
        coefficients match {
          case head :: Nil  => head * math.pow(x, powers.head) + acc
          case head :: tail => fUtil(tail, powers.tail, x, acc + head * math.pow(x, powers.head))
        }
    }
    fUtil(coefficients, powers, x, 0)
  }

  // This function will be used while invoking "Summation" to compute 
  // The Volume of revolution of the curve around the X-Axis
  // The 'Area' referred to here is the area of the circle obtained
  // By rotating the point on the curve (x,f(x)) around the X-Axis
  def area(coefficients: List[Int], powers: List[Int], x: Double): Double = {
    // To compute the area of the circle on revolving the point
    // (x,f(x)) around the X-Axis
    // For the given coefficients, powers and value of x
    def areaUtil(coefficients: List[Int], powers: List[Int], x: Double, acc: Double): Double = {
        coefficients match {
          case head :: Nil  => acc + head * math.pow(x, powers.head)
          case head :: tail => areaUtil(tail, powers.tail, x, acc + head * math.pow(x, powers.head))
        }
    }
    math.pow(areaUtil(coefficients, powers, x, 0), 2) * math.Pi
  }

  // This is the part where the series is summed up
  // This function is invoked once with func = f to compute the area
  // under the curve
  // Then it is invoked again with func = area to compute the volume 
  // of revolution of the curve

  // Have to use tail recursion otherwise StackOverFlow error will be raised.
  def summation(func: (List[Int], List[Int], Double) => Double, upperLimit: Int,
    lowerLimit: Int, coefficients: List[Int], powers: List[Int]): Double = {
    def summationUtil(func: (List[Int], List[Int], Double) => Double, upperLimit: Int,
      coefficients: List[Int], powers: List[Int], step: Double, acc: Double): Double = {
      step match {
        case _ if step > upperLimit => acc
        case _ => summationUtil(func, upperLimit, coefficients, powers, step + 0.001,
                  acc + func(coefficients, powers, step) * 0.001)
      }               
    }
    "%.1f".format(summationUtil(func, upperLimit, coefficients, powers, lowerLimit, 0)).toDouble
  }
}
