package main.scala.files

import main.scala.Recursion

object AocApp extends App {
  println("AOC APP Run")
  FileReader.read() match {
    case Some(_) =>
      val result = Recursion.calculator(_, 0)
      println(result)
    case None =>
      println("Issue reading file input")
  }

}
