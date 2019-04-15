package main.scala

object Multiplication {

  def persistence(n: Int): Int = {
    def multiplyNumber(n: Int, counter: Int = 0): Int = {
      n match {
        case x if x < 10 => counter
        case _ => multiplyNumber(n.toString.map {_.asDigit}.product, counter + 1)
      }
    }
    multiplyNumber(n)
  }
}
