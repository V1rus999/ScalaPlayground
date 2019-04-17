package main.scala

import main.scala.`trait`.Child
import main.scala.tuples.StockInfo
import Mapper._

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by johannesC on 2019/03/12.
  */
object HelloWorld extends App {
  println("Hello world")

  val child = new Child()
  child.printAll()

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

  implicit val intList: List[Int] = List.range(1, 5)
  val boolList = Mapper.intMap({
    _ % 2 == 0
  }, intList)
  println("Bool list from int list")
  println(boolList)

  //Compiler is smart enough to use int list above
  val boolListFromGenMap = Mapper.genMap[Int, Boolean]({
    _ % 2 == 0
  })
  println("Bool list from gen map list")
  println(boolListFromGenMap)

  //Compiler is smart enough to use the gen map implicit class/method from the mapper class
  val boolListFromImplClass = intList.genMap({
    _ % 2 == 0
  })
  println("Bool list from gen map class")
  println(boolListFromImplClass)

  println("Starting network request")
  val networker = new IntoTheFuture
  val result = Await.result(networker.doMyLongRunningRequest("Hi there"), 10 seconds)
  println(s"Got network cb $result")

  println("Starting long running func")
  val resultOfFunc = Await.result(networker.doMyLongRunningFunc({
    println("Hi Func")
    10
  }), 10 seconds)
  println(s"Got long running func cb $resultOfFunc")
}



