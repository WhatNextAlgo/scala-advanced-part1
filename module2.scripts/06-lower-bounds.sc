trait CombineWith[T]{
  val item:T
  def combineWith(another:T):T
}

case class CombineWithInt(item:Int) extends CombineWith[Int]{
  def combineWith(another:Int) = item + another
}

val cwi = CombineWithInt(10)
cwi.combineWith(15)
//cwi.combineWith("string")


abstract class Food {val name:String}

abstract class Fruit extends Food
case class Orange(name:String) extends Fruit
case class Apple(name:String) extends Fruit

abstract class Cereal extends Food
case class Granola(name:String) extends Cereal
case class Muesli(name:String) extends Cereal

case class MixedFoodBowl[+F <:Food](food1:F,food2:F) {
  override def toString: String = s"${food1.name} mixed with ${food2.name}"
}

case class FoodBowl[+F <: Food](food:F){
  override def toString: String = s"A bowl of ${food.name}"
  def mix[M >: F <:Food](other:M):MixedFoodBowl[M] = MixedFoodBowl(food,other)
}

val appleBowl = FoodBowl(Apple("Fuji"))
appleBowl.mix(Orange("orange"))
appleBowl.mix(Muesli("Alpen"))
