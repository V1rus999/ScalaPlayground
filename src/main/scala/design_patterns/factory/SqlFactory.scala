package main.scala.design_patterns.factory

class SqlFactory extends DbConnectorFactory {
  override def connect: SimpleConnection = new SimpleSqlConnection
}
