package main.scala

object FunctionStuff {

  def createPrinter[T](): T => Unit = (toPrint: T) => {
    println(s"From printer $toPrint")
  }

  def invokerOfMethods(methodToInvoke: () => Unit) {
    methodToInvoke()
  }

  def invokableMethod(): Unit = {
    println("Hi man")
  }

  def execTwoFunctions(func1: (Int, Int) => Int,
                       func2: (Int, Int) => Int,
                       x: Int,
                       y: Int): (Int, Int) = Tuple2(func1(x, y), func2(x, y))

}
