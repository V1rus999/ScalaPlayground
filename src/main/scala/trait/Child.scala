package main.scala.`trait`

import main.scala.HelloWorld.child

/**
  * Created by johannesC on 2019/03/23.
  */
class Child extends Human with Mother with Father {

  def printSuper = super.hello
  def printMother = super[Mother].hello
  def printFather = super[Father].hello
  def printHuman = super[Human].hello

  def printAll(): Unit = {
    println(s"c.printSuper  = ${this.printSuper}")
    println(s"child.printMother = ${this.printMother}")
    println(s"child.printFather = ${this.printFather}")
    println(s"child.printHuman  = ${this.printHuman}")
  }
}
