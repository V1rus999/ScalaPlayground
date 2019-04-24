package main.scala.files

import scala.io.Source

object FileReader {
  def read(): Option[List[(String, Int)]] = {
    try {
      val source = Source.fromFile("files/day1Advent.txt")
      val stringList = List() ++ source.getLines()
      val convertedMap = stringList.map(it => (it.head.toString, Integer.parseInt(it.tail)))
      source.close()
      Some(convertedMap)
    } catch {
      case _: Exception => None
    }
  }
}
