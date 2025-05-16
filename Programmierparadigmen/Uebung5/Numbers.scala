package Uebung5

import scala.annotation.tailrec

object Numbers {

  def relativePrimes(n: Int): List[Int] = {
    relativePrimes_helper(List[Int](), n, 2)
  }

  @tailrec
  private def relativePrimes_helper(teilerfremd: List[Int], n: Int, i: Int): List[Int] = {
    if (i == n) teilerfremd
    else {
      if (gcd(n, i) == 1) relativePrimes_helper(teilerfremd :+ i, n, i + 1)
      else relativePrimes_helper(teilerfremd, n, i + 1)
    }
  }

  @tailrec
  def gcd(a: Int, b: Int): Int = {
    if (a == 0) return b
    if (b == 0) return a
    gcd(b, a % b)
  }

  def main(args: Array[String]): Unit = {
    println(gcd(2970, 12936))
    println(relativePrimes(37))
    println(relativePrimes(50))
    println(relativePrimes(27))
  }
}