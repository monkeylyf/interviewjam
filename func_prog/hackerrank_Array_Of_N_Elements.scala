/*hackerrank_Array_Of_N_Elements
hackerrank

https://www.hackerrank.com/challenges/fp-array-of-n-elements
*/




object hackerrank_Array_Of_N_Elements {
  
  def main(args: Array[String]) = {
    println(f(5))
  }  

  //Easy list creation practice using tail recursion
  def f(n: Int): List[Int] = {
    def fUtil(n: Int, acc: List[Int]): List[Int] = {
      n match {
        case 0 => acc
        // You can manipulate the content to append here.
        case _ => fUtil(n - 1, n :: acc)
      }
    }
    fUtil(n, List())
  } 
}
