abstract class Food {val name:String}

abstract class Fruit extends Food
case class Orange(name:String) extends Fruit
case class Apple(name:String) extends Fruit

abstract class Cereal extends Food
case class Muesli(name:String) extends Cereal

abstract class FoodBowl2{
  type FOOD <: Food
  val food:FOOD
  def eat:String = s"Yummy ${food.name}"
}

class AppleBowl(val food:Apple) extends FoodBowl2{
  override type FOOD = Apple
}

val appleBowl = new AppleBowl(Apple("fiji"))
appleBowl.eat

val apple2:appleBowl.FOOD = appleBowl.food
val apple3:AppleBowl#FOOD = appleBowl.food