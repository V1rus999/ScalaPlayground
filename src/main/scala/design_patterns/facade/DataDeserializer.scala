package main.scala.design_patterns.facade

trait DataDeserializer {

  case class Data(data: String)

  protected def parse(data: String): Data = {
    Data(data)
  }
}
