/** hackerrank_Reverse_Factorization
 *
 *  https://www.hackerrank.com/challenges/reverse-factorization
 */


object Solution {

  def main(args: Array[String]) = {
    val NK = readLine()
               .split(" ")
               .map(x => x.toInt)
    val xs = readLine()
               .split(" ")
               .map(x => x.toInt)
               .sortWith(_ > _) // Descending order.
               .toList

    val N = NK(0)
    val K = NK(1)

    factorial(N, xs)
  }

  def factorial(N: Int, xs: List[Int]): Unit = {
    def rec(N: Int, xs: List[Int], acc: List[Int]): List[Int] = xs match {
      case Nil if N == 1          => acc
      case Nil                    => List(-1)
      case x :: xs  if N % x == 0 => rec(N / x, x :: xs, x :: acc)
      case x :: xs                => rec(N, xs, acc)
    }

    val res = rec(N, xs, List[Int]())
    res match {
      case -1 :: Nil => print(-1)
      case _         => res.foldLeft(List[Int](1))((acc, x) => x * acc.head :: acc).reverse.foreach(x => print(x + " ")) // States.
    }

    println()
  }
}
