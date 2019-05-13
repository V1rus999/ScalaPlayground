package main.scala.design_patterns.factory

class PgSqlFactory extends DbConnectorFactory {
  override def connect: SimpleConnection = new SimplePgSqlConnection
}

