abstract class Food {val name:String}

abstract class Fruit extends Food
case class Banana(name:String) extends Fruit
case class Apple(name:String) extends Fruit

abstract class Cereal extends Food
case class Granola(name:String) extends Cereal
case class Muesli(name:String) extends Cereal

val fuji = Apple("Fuji")
val alpen = Muesli("Alpen")

def eat(f:Food):String = s"${f.name}"

eat(fuji)
eat(alpen)

case class Bowl(food:Food){
  override def toString: String = s"A bowl of yummy ${food.name}"
  def contents= food
}
val fruitBowl = Bowl(fuji)
fruitBowl.contents
val cerealBowl = Bowl(alpen)
cerealBowl.contents


case class Bowl2[F](contents:F){
  override def toString: String = s"A bowl of yummy ${contents}"
}
val fruitBowl2 = Bowl2(fuji)
fruitBowl2.contents
val cerealBowl2 = Bowl2(alpen)
cerealBowl2.contents


case class Bowl3[F <: Food](contents:F){
  override def toString: String = s"A bowl of yummy ${contents.name}"
}
val fruitBowl3 = Bowl3(fuji)
fruitBowl3.contents.name
val cerealBowl3 = Bowl3(alpen)
cerealBowl3.contents.name

