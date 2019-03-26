package main.scala

/**
  * Created by johannesC on 2019/03/23.
  */
class ClassWithoutNew {
  var name : String = _
}

object ClassWithoutNew {
  def apply(name : String) : ClassWithoutNew = {
    val c = new ClassWithoutNew
    c.name = name
    c
  }
}
