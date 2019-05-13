package main.scala.design_patterns.factory

trait SimpleConnection {
  def getName() : String
  def executeQuery(query : String) : Unit
}
