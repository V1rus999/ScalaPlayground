package main.scala

import scala.annotation.tailrec

object Recursion {

  def printSum(): Unit = {
    println(sum(List.range(1, 10)))
  }

  //This one can run a 10k list
  def sum(nrs: List[Int]): Int = {
    if (nrs.nonEmpty) nrs.head + sum(nrs.tail) else 0
  }

  //This one cannot run a 10k list (Stackoverflow)
  def sumEvenCleaner(nrs: List[Int]): Int = nrs match {
    case Nil => 0
    case first :: theRest => first + sumEvenCleaner(theRest)
  }

  // The above algorithms fail because the JVM stack gets filled up because we are running multiple calls to sum (adding multiple instances of sum to the stack)
  // Tailrec is a function whose very last action is to call itself and thus not fill up the JVM stack
  // Adding @tailrec on a non tail rec function will fail. This can be used to see if a function conforms to tailrec
  @tailrec
  def sumWithTailRec(nrs: List[Int], accumulator: Int): Int = nrs match {
    case Nil => accumulator
    case first :: theRest => sumWithTailRec(theRest, accumulator + first)
  }
}