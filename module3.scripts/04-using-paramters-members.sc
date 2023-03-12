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

object BowlOfFood{
  def apply[F <:Food](f:F) = new FoodBowl2{
    override type FOOD = F
    override val food: FOOD = f
  }

}

val bowlOfAlpen = BowlOfFood(Muesli("Aplen"))

val appleBowl = BowlOfFood(Apple("Fiji"))

val a1:Apple = appleBowl.food
val a2:appleBowl.FOOD = appleBowl.food