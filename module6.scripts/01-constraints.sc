import scala.annotation.implicitNotFound
trait Food {def name:String}

case class Fruit(name:String) extends Food
case class Cereal(name:String) extends Food
case class Meat(name:String) extends Food
trait Eater {def name:String}
case class Vegan(name:String) extends Eater
case class Vegetarian(name:String) extends Eater
case class Paleo(name:String) extends Eater



//@implicitNotFound(msg=s"Illegal Feeding, No Eats rule from ${EATER} to ${FOOD}")
trait Eats[EATER <: Eater,FOOD <: Food]{
  def feed(food:FOOD,eater:EATER):String = s"${eater.name} eats ${food.name}"
}

def feedTo[FOOD <:Food,EATER <: Eater](food:FOOD,eater:EATER)(implicit ev:Eats[EATER,FOOD])={
  ev.feed(food, eater)
}

val apple = Fruit("Apple")
val alpen = Cereal("Alpen")
val beef = Meat("Beef")
val alice = Vegan("Alice")
val bob = Vegetarian("Bob")
val charlie = Paleo("Charlie")

object VeganRules {
  implicit object veganEatsFruit extends (Vegan Eats Fruit)
}

import VeganRules._

feedTo(apple,alice)

object VegetarianRules {
  implicit object vegEatsFruit extends (Vegetarian Eats Fruit)
  implicit object vegEatsCereal extends (Vegetarian Eats Cereal)
}
import VegetarianRules._

feedTo(alpen,bob)
feedTo(apple,bob)

object PaleoRules {
  implicit object palEatsFruit extends (Paleo Eats Fruit)
  implicit object palEatsMeat extends (Paleo Eats Meat)
}
import PaleoRules._

feedTo(apple,charlie)
feedTo(beef,charlie)