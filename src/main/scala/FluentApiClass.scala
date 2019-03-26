package main.scala

/**
  * Created by johannesC on 2019/03/23.
  */
class FluentApiClass {

  private var name = ""
  private var path = ""
  private var extension = ""

  def setClassName(name : String) : this.type = {
    this.name = name
    this
  }

  def setClassPath(path : String) : this.type = {
    this.path = path
    this
  }

  def setClassExtension(extension : String) : this.type = {
    this.extension = extension
    this
  }

  override def toString = s"$path$name$extension"

  def print = println(toString)
}
