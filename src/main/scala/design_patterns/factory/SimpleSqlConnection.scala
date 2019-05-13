package main.scala.design_patterns.factory

class SimpleSqlConnection extends SimpleConnection {

  override def getName(): String = "SimpleSqlConnection"

  override def executeQuery(query: String): Unit = println(s"Executing sql query $query")
}
