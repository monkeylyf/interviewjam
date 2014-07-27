/**
 * hackerrank_Matrix_Rotation.
 *
 * https://www.hackerrank.com/contests/lambda-calculi-jul14/challenges/matrix-rotation
 */


object Solution {
  def main(args: Array[String]): Unit = {
    val mnr = io.StdIn.readLine.split(" +")
    val m = mnr(0).toInt
    val n = mnr(1).toInt
    val r = mnr(2).toLong
    val matrix = Array.ofDim[Long](m, n)
    for (i <- 0 until m) {
      matrix(i) = io.StdIn.readLine.split(" +").map(_.toLong)
    }
    solve(matrix, r, m, n)
  }

  def rotate(r: Long, xs: List[Long]): List[Long] = {
    val shift = (r % xs.length).toInt
    (xs drop shift) ::: (xs take shift)
  }

  def solve(matrix: Array[Array[Long]], r: Long, m: Int, n: Int): Unit = {
    def rotateLayer(matrix: Array[Array[Long]], r: Long,
                    imin: Int, jmin: Int, imax: Int, jmax: Int): Unit = {
      if (imin >= imax || jmin >= jmax) {
        return
      } else {
        var layer = List[Long]()
        // Upper.
        for (i <- jmin until jmax) {
          layer = matrix(imin)(i) :: layer
        }
        // Right.
        for (i <- imin until imax) {
          layer = matrix(i)(jmax) :: layer
        }
        // Down.
        for (i <- (jmin + 1 to jmax).reverse) {
          layer = matrix(imax)(i) :: layer
        }
        // Left.
        for (i <- (imin + 1 to imax).reverse) {
          layer = matrix(i)(jmin) :: layer
        }

        var rotatedLayer = rotate(r, layer.reverse)

        // Upper.
        for (i <- jmin until jmax) {
          matrix(imin)(i) = rotatedLayer.head
          rotatedLayer = rotatedLayer.tail
        }
        // Right.
        for (i <- imin until imax) {
          matrix(i)(jmax) = rotatedLayer.head
          rotatedLayer = rotatedLayer.tail
        }
        // Down.
        for (i <- (jmin + 1 to jmax).reverse) {
          matrix(imax)(i) = rotatedLayer.head
          rotatedLayer = rotatedLayer.tail
        }
        // Left.
        for (i <- (imin + 1 to imax).reverse) {
          matrix(i)(jmin) = rotatedLayer.head
          rotatedLayer = rotatedLayer.tail
        }
        // Recursion.
        rotateLayer(matrix, r, imin + 1, jmin + 1, imax - 1, jmax - 1)
      }
    }

    rotateLayer(matrix, r, 0, 0, m - 1, n - 1)
    printMatrix(matrix)
  }

  def printMatrix(matrix: Array[Array[Long]]): Unit = {
    for (i <- 0 until matrix.length) {
      println(matrix(i).mkString(" "))
    }
  }
}
