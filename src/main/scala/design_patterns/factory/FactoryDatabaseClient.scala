package main.scala.design_patterns.factory

abstract class FactoryDatabaseClient {
  def executeQuery(query: String): Unit = {
    connect().executeQuery(query)
  }

  protected def connect() : SimpleConnection

}
