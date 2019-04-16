package main.scala

object Mapper {

  def intMap[T](mapFunc: Int => T, list: List[Int]): List[T] = {
    for {
      item <- list
    } yield mapFunc(item)
  }

}
