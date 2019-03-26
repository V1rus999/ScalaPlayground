val hello = "Hello World"

def boolToInt(value: Boolean) = if (value) 1 else 0

println(boolToInt(true))
println(boolToInt(false))

42

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

def printType(obj: AnyRef) = obj match {
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

//This is like an extention function in Kotlin
implicit class BinaryUtil(s: String) {
  def toBinary = Integer.parseInt(s, 2)
}

val binary = "1001"
binary.toBinary

val someRange = 1 to 5

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

val double = (i : Int) => { i * 2}
println(double(3))

