abstract class Food {val name:String}

abstract class Fruit extends Food
case class Orange(name:String) extends Fruit
case class Apple(name:String) extends Fruit

abstract class Cereal extends Food
case class Muesli(name:String) extends Cereal

case class FoodBowl[+F <: Food](food:F){
  def eat:String = s"Yummy ${food.name}"
}

val fiji = Apple("Fiji")
val jaffa = Orange("Jaffa")
val alpen = Muesli("Alpen")

val appleBowl = FoodBowl(fiji)
appleBowl.eat