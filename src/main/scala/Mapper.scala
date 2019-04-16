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
}
