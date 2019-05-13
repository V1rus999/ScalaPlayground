package main.scala.design_patterns.factory

trait DbConnectorFactory {
  def connect: SimpleConnection
}
