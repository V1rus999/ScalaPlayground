package main.scala.design_patterns.factory

class AbstractFactoryDatabaseClient(connectorFactory: DbConnectorFactory) {
  def executeQuery(query: String): Unit = {
    connectorFactory.connect.executeQuery(query)
  }
}
