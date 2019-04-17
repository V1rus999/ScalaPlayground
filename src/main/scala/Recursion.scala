package main.scala

object Recursion {

  def printSum(): Unit = {
    println(sum(List.range(1, 10)))
  }

  def sum(nrs: List[Int]): Int = {
    if (nrs.nonEmpty) nrs.head + sum(nrs.tail) else 0
  }

  def sumEvenCleaner(nrs: List[Int]): Int = nrs match {
    case Nil => 0
    case first :: theRest => first + sumEvenCleaner(theRest)
  }

}
