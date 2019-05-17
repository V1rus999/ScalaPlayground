//Faking function calls
class Directory {
  private val musketeers = scala.collection.mutable.Map(
    "Athos" -> "AthosVille",
    "Porthos" -> "PorthosBurg",
    "Aramis" -> "AramisTown",
    "Artagnan" -> "D`ArtagnanVillage"
  )

  def apply(name: String) = {
    musketeers.get(name)
  }

  def apply(retrieveNth: Int): Option[String] = {
    musketeers.values.slice(retrieveNth - 1, retrieveNth + 1).headOption
  }

  def update(name: String, address: String): Unit = {
    musketeers.update(name, address)
  }
}

val directory = new Directory()
val athosAddress = directory("Athos") //Because we specified the apply method the compiler will automatically call it. You don't have to use directory.apply()
directory("Athos") = "NewAthosVille" //We specified the update method so we don't call directory.update()
val newAthosAdress = directory("Athos")
println(athosAddress)
println(newAthosAdress)
println(directory(1))


//Pattern Matching
val month = "August"
//Will match on word directly so capital matching etc basically ==
val quarter = month match {
  case "January" | "February" | "March" => "1st quarter"
  case "April" | "May" | "June" => "2st quarter"
  case "July" | "August" | "Sept" => "3st quarter"
  case "October" | "November" | "December" => "4st quarter"
  case _ => "Error"
}

//Constructor Matching
case class SuperHero(heroName: String, alterEgo: String, powers: List[String])

val batman = SuperHero("Batman", "Bruce Wayne", List("Intelligence", "Speed", "Wealth", "Super good looks"))
val hero = SuperHero("Superman", "Clark Kent", List("XRay", "Invincibility", "Flight"))

// _ mean don't care
def matchHero(hero: SuperHero): Unit = hero match {
  case SuperHero(_, "Bruce Wayne", _) => println("I AM BATMAN!!")
  case SuperHero(name, _, powers) => println(s"$name has powers $powers")
  case _ => println("Don't know who this is")
}

matchHero(batman)
matchHero(hero)

//For comprehension
object CustomerDb {
  type Address = String
  type Code = Option[String]

  case class CompleteAddress(address: Address, code: Code)

  case class Customers(name: String, address: Option[CompleteAddress])

  val customers = List(
    Customers("Albert", Some(CompleteAddress("Joburg", None))),
    Customers("John", Some(CompleteAddress("Pretoria", Some("123 345")))),
    Customers("Carol", None),
  )

  val all = Set("Albert", "John", "Carol", "NoOne")

  def run(): Unit = {
    for {
      name <- all //Go through each name
      customer <- customers.find(it => it.name == name) //Find customer that matches name this will not return NoOne
      address <- customer.address //Find someone with a valid address (not NONE)
      postCode <- address.code //Find someone with a valid Code (not NONE)

    } yield {
      println(s"$name $address $postCode") //This will only yield someone that has a valid address and code and no "NONE" values
    }
  }
}

CustomerDb.run()
