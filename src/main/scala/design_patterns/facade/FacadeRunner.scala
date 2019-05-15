package main.scala.design_patterns.facade

object FacadeRunner {
  //Facade obfuscates the how. This is especially useful when writing libraries as you want to hide complexities to promote ease of use
  def run() {
    val dataReader = new DataReader
    val data = dataReader.getData("google.com/somedata")
    println(data)
  }
}
