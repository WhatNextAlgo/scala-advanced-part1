trait Food { val name:String}
trait Fruit extends Food
trait Cereal extends Food
case class Apple(name:String) extends Fruit
case class Muesli(name:String) extends Cereal

val fiji = Apple("fiji")
val alpen = Muesli("Alpen")
case class FoodBowl[+F <: Food](item:F)
val appleBowl = FoodBowl[Apple](fiji)
val muesliBowl = FoodBowl[Muesli](alpen)

def feedToFruitEater(bowl:FoodBowl[Fruit]) = println(s"Yummy ${bowl.item.name}")
feedToFruitEater(appleBowl)
//feedToFruitEater(muesliBowl)

abstract  class FoodBowl2{
  type FOOD <: Food
  val item : FOOD
}
class AppleBowl extends  FoodBowl2{
  type FOOD =Apple
  val item = fiji
}
class MuesliBowl extends  FoodBowl2{
  type FOOD =Muesli
  val item = alpen
}

def feedToFruitEater(bowl:FoodBowl2) =
  println(s"Yummy ${bowl.item.name}")

feedToFruitEater(new AppleBowl)
feedToFruitEater(new MuesliBowl)
def safeFeedToFruitEater(bowl:FoodBowl2{ type FOOD <: Fruit}) =
  println(s"Yummy ${bowl.item.name}")

safeFeedToFruitEater(new AppleBowl)
//safeFeedToFruitEater(new MuesliBowl)