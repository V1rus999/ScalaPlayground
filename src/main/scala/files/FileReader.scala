package main.scala.files

import scala.io.Source

object FileReader {
  def read(): List[(String, Int)] = {
    val source = Source.fromFile("files/day1Advent.txt")
    val string = List() ++ source.getLines()
    val convertedMap = string.map(it => (it.head.toString, Integer.parseInt(it.tail)))
    source.close()
    convertedMap
  }
}
