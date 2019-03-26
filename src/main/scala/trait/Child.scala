package main.scala.`trait`

/**
  * Created by johannesC on 2019/03/23.
  */
class Child extends Human with Mother with Father {

  def printSuper = super.hello
  def printMother = super[Mother].hello
  def printFather = super[Father].hello
  def printHuman = super[Human].hello
}
