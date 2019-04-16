package main.scala

import main.scala.`trait`.Child
import main.scala.tuples.StockInfo

/**
  * Created by johannesC on 2019/03/12.
  */
object HelloWorld extends App {
  println("Hello world")

  val child = new Child()
  println(s"c.printSuper  = ${child.printSuper}")
  println(s"child.printMother = ${child.printMother}")
  println(s"child.printFather = ${child.printFather}")
  println(s"child.printHuman  = ${child.printHuman}")

  val (symbol, currentPrice, bidPrice) = new StockInfo().getStockInfoFor("AMZ")
  println(s"$symbol current price is $currentPrice with a bid price of $bidPrice")

  val someClass = new FluentApiClass()
  someClass.
    setClassName("HelloWorld")
    .setClassPath("/main/scala/")
    .setClassExtension(".scala")
  someClass.print

  val classWithoutNew = ClassWithoutNew(ClassWithoutNew.getClass.toString)
  println(classWithoutNew.name)

  val generics = new Generics()
  val stringMonoid = generics.getMonoidForMyThing("MyStringThatShouldBeWrapped")
  println(stringMonoid.retrieve)
  val nullThing = generics.getMonoidForMyThing(null)
  println(nullThing.retrieve)

  println(Multiplication.persistence(999))

  val stringPrinter = FunctionStuff.createPrinter[String]()
  stringPrinter("Hi")

  val objectPrinter = FunctionStuff.createPrinter[Generics]()
  objectPrinter(generics)

  FunctionStuff.invokerOfMethods(FunctionStuff.invokableMethod)

  val (sum, mult) = FunctionStuff.execTwoFunctions({ (x, y) => x + y }, { (x, y) => x * y }, 15, 20)
  println(s"execTwoFunctions Sum $sum Mult $mult")

  val intList = List.range(1, 10)
  val boolList = Mapper.intMap({_ % 2 == 0}, intList)
  println("Bool list from int list")
  println(boolList)
}



