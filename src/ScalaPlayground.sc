val hello = "Hello World"

object Scoring {
  def high(s: String): String = {
    s.split(' ').reduceLeft((a, b) => {
      println(s"$a ${a.sum.toInt} $b ${b.sum.toInt}")
      if (a.sum > b.sum) a else b})
  }
}

println(Scoring.high("what time are we climbing up to the volcano"))

//Return = 672
// earliestg = 960

//Climbing = 3(99) + 12(108) + 9(105) + 13(109) + 2(98) + 13(105) + 14(110) + 7(103) = 73 (837)
// volcano = 22(118) + 15(111) + 12(108) + 3(99) + 1(97) + 14(110) + 15(111) = 82 (754)

def boolToInt(value: Boolean) = if (value) 1 else 0

println(boolToInt(true))
println(boolToInt(false))

val pNr = (n: Int) => println(s"Number $n")

val numbers = List(1, 2, 3, 4)
for (nr <- numbers) {
  pNr(nr)
}
numbers.foreach(item => pNr(item)) //This is the same as the line below
numbers.foreach(pNr(_)) // _ is used to infer value based on context
numbers.foreach(pNr) // Also works as the int is inferred

for (nr <- numbers if nr % 2 == 0) pNr(nr)

def someFunction = "Some method"

println(someFunction)

def printType(obj: AnyRef): Unit = obj match {
  case _: String => println("This is a string")
  case _: List[_] => println("This is an array")
  case _ => throw new IllegalArgumentException("This is an unsupported type")
}

printType("Hello")
printType(numbers)
try {
  printType(Array(1, 2))
} catch {
  case e: IllegalArgumentException => println(e.getMessage)
}

val s = "eggs, milk, butter, Coco Puffs"
val arrayOfStuff = s.split(",").map(_.trim).map(_.capitalize)

//You can add a counter to a loop
for ((item, counter) <- arrayOfStuff.zipWithIndex) {
  println(s"$item is Nr $counter in array")
}

val weight = 200.00
val weightS = s"You weigh $weight%.2f kg"
val weightF = f"You weigh $weight%.0f kg"
val escapedString = raw"\nWill not be on a new line"

val stringToSearch = "ABCDEFGIJK"
stringToSearch.find(_ == 'H')
stringToSearch.find(_ == 'A')
stringToSearch find (_ == 'A')

//This is like an extension function in Kotlin
implicit class BinaryUtil(s: String) {
  def toBinary = Integer.parseInt(s, 2)
}

val binary = "1001"
binary.toBinary

// Traits and options
trait Animal {
  val greeting: Option[String]
  val age: Option[Int] = None

  override def toString = s"I say $greeting, and I'm $age years old."
}

class Dog extends Animal {
  override val greeting: Option[String] = Some("Woof")
}

val dog = new Dog()
dog.toString


// Function literals
val longerIsEven = (n: Int) => n % 2 == 0

val implicitIsEven: Int => Boolean = _ % 2 == 0

val isTheSame: (Int, Int) => Boolean = _ == _
println(isTheSame(3, 1))

val list = List.range(1, 10)
val even = list.filter(implicitIsEven)
println(even)

// Partial functions
val double = (i: Int) => {
  i * 2
}
println(double(3))
println(implicitIsEven(double(3)))

val partialDouble = double(_)
println(partialDouble(2))

val sum = (a: Int, b: Int, c: Int) => {
  a + b + c
}

val curriedSum = sum.curried //This converts the single parameter group into multiple parameter groups
// With normal sum you call sum(1,2,3), with the curried version you can call
val partialCurry = curriedSum(1)(_: Int)(3)

val sumWithoutC = sum(2, 4, _: Int)
println(sumWithoutC(6))


object Parity {

  val lookForEven: Int => Boolean = _ % 2 == 0
  val lookForOdd: Int => Boolean = _ % 2 != 0

  def findOutlier(integers: List[Int]): Int = {
    val check = if (integers.sum % 2 == 0) lookForOdd else lookForEven
    integers.filter(check).head
  }
}


