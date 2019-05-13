package main.scala.design_patterns.factory

class MyPgSqlClient extends FactoryDatabaseClient {
  override protected def connect(): SimpleConnection = new SimplePgSqlConnection
}
