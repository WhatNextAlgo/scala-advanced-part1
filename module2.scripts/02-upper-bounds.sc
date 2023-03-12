abstract class Food {val name:String}

abstract class Fruit extends Food
case class Banana(name:String) extends Fruit
case class Apple(name:String) extends Fruit

abstract class Cereal extends Food
case class Granola(name:String) extends Cereal
case class Muesli(name:String) extends Cereal

val fuji = Apple("Fuji")
val alpen = Muesli("Alpen")

case class Bowl[F](contents:F){
  override def toString: String = s"A bowl of yummy ${contents}"
}

abstract class Animal{
  val name:String
  override def toString: String = s"Animal -$name"
}
case class Dog(name:String) extends Animal
val dottie = Dog("Dottie")
val dogBowl = Bowl(dottie)

case class FoodBowl[F <: Food](food:F){
  override def toString: String = s"A yummy bowl of ${food.name}"
}
val appleBowl = FoodBowl(fuji)
//val dogBowl2 = FoodBowl(dottie)