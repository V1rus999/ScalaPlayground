package main.scala

object Mapper {

  def intMap[T](mapFunc: Int => T, list: List[Int]): List[T] = {
    for {
      item <- list
    } yield mapFunc(item)
  }

  def genMap[Input, Return](mapFunc: Input => Return)(implicit list: List[Input]): List[Return] = {
    for {
      item <- list
    } yield mapFunc(item)
  }

  implicit class MyMapper[Input](list: List[Input]) {
    def genMap[Return](mapFunc: Input => Return): List[Return] = {
      for {
        item <- list
      } yield mapFunc(item)
    }
  }
}
