package main.scala

class Generics {

  def getMonoidForMyThing[T](whatever : T) : Monoid[T] = new Monoid[T] {
    override def retrieve: T = whatever
  }

}

trait Monoid[A] {
  def retrieve : A
}