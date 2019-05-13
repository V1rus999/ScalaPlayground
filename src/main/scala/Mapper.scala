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

    def makeInt(s: String): Option[Int] = {
      try {
        Some(s.trim.toInt)
      } catch {
        case _: Exception => None
      }
    }

    //Old way
    val x = makeInt("6")
    val y = makeInt("7")
    x match {
      case None =>
        y match {
          case None => 0
          case Some(i) => i
        }

      case Some(i) => y match {
        case None => i
        case Some(j) => i + j
      }
    }

    //This is long and tedious

    //Better Solution: Use flatmap and map. Doesnt handle an empty case
    x.flatMap(a => y.map(b => a + b))

    //Even better Solution. Easier to read. Doesnt handle an empty case makeInt("ABC"). Happy path only
    for {
      x <- makeInt("6")
      y <- makeInt("7")
    } yield {
      x + y
    }
  }
}
