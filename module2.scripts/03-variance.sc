abstract class Food {val name:String}

abstract class Fruit extends Food
case class Banana(name:String) extends Fruit
case class Apple(name:String) extends Fruit

abstract class Cereal extends Food
case class Granola(name:String) extends Cereal
case class Muesli(name:String) extends Cereal

val fuji = Apple("Fuji")
val alpen = Muesli("Alpen")

case class FoodBowl[F <: Food](contents:F){
  override def toString: String = s"A yummy bowl of ${contents.name}"
}

def serveToFruitEater(fruitBowl:FoodBowl[Fruit]) =
  s"mmm, those ${fruitBowl.contents.name}s were very good"

val fruitBowl = FoodBowl[Fruit](fuji)
val cerealBowl = FoodBowl[Cereal](alpen)
serveToFruitEater(fruitBowl)
//serveToFruitEater(cerealBowl)

def serveToFoodEater(foodBowl:FoodBowl[Food]) =
  s"mmm, those ${foodBowl.contents.name}s were very good"


val foodBowl1 = FoodBowl[Food](fuji)
val foodBowl2 = FoodBowl[Food](alpen)
serveToFoodEater(foodBowl1)
serveToFoodEater(foodBowl2)

case class FoodBowl2[+F <: Food](contents:F){
  override def toString: String = s"A yummy bowl of ${contents.name}"
}

def serveToFoodEater(foodBowl:FoodBowl2[Food]) =
  s"mmm, those ${foodBowl.contents.name}s were very good"

serveToFoodEater(FoodBowl2(fuji))
serveToFoodEater(FoodBowl2[Cereal](alpen))

def serveToFruitEater(foodBowl:FoodBowl2[Fruit]) =
  s"mmm, those ${foodBowl.contents.name}s were very good"

//serveToFruitEater(FoodBowl2(alpen))
//serveToFruitEater(FoodBowl2[Food](alpen))