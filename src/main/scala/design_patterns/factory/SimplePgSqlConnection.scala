package main.scala.design_patterns.factory

class SimplePgSqlConnection extends SimpleConnection {

  override def getName(): String = "SimplePgSqlConnection"

  override def executeQuery(query: String): Unit = println(s"Executing PG sql query $query")
}
