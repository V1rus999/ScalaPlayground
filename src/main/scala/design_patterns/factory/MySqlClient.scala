package main.scala.design_patterns.factory

class MySqlClient extends FactoryDatabaseClient {
  override protected def connect(): SimpleConnection = new SimpleSqlConnection
}
