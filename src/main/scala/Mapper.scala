package main.scala

object Mapper {

  def intMap[T](mapFunc: Int => T, Seq: Seq[Int]): Seq[T] = {
    for {
      item <- Seq
    } yield mapFunc(item)
  }

  def genMap[Input, Return](mapFunc: Input => Return)(implicit Seq: Seq[Input]): Seq[Return] = {
    for {
      item <- Seq
    } yield mapFunc(item)
  }

  implicit class MyMapper[Input](Seq: Seq[Input]) {
    def genMap[Return](mapFunc: Input => Return): Seq[Return] = {
      for {
        item <- Seq
      } yield mapFunc(item)
    }
  }

  def showMapVsFlatMap(): Unit = {
    val list = List("foo", "bar")

    println("showMapVsFlatMap")
    val mapResult = list.map(_.split(""))
    println(mapResult) // This results in a list with two lists foo and bar
    val flatMapResult = list.flatMap(_.split(""))
    println(flatMapResult) // This results in one list with foobar
  }
}
