package main.scala.design_patterns.factory

import scala.util.Try

object DbUser {

  def executeDbCalls(): Unit = {
    //Factory Pattern
    val sqlClient = new MySqlClient
    val pgClient = new MyPgSqlClient
    sqlClient.executeQuery("Sql")
    pgClient.executeQuery("pgSql")

    //AbstractFactory Pattern
    val sqlFactory = new AbstractFactoryDatabaseClient(new SqlFactory)
    val pgSqlFactory = new AbstractFactoryDatabaseClient(new PgSqlFactory)
    sqlFactory.executeQuery("Sql")
    pgSqlFactory.executeQuery("pgSql")


  }

}
