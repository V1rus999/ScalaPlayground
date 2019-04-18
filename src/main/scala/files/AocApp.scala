package main.scala.files

import main.scala.Recursion

object AocApp extends App {
  println("AOC APP Run")
  val result = Recursion.calculator(FileReader.read(), 0)
  println(result)

}
