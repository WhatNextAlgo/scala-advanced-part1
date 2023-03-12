val conversionKilosInPounds = 2.20462262185
case class Potato(weightInKilos:Double){
  val weightInPounds = weightInKilos * conversionKilosInPounds
}
val p1 = Potato(0.75)
p1.weightInKilos
p1.weightInPounds

case class Person(name:String,weightInPounds:Double){
  def weightInKilos = weightInPounds / conversionKilosInPounds
}

val p2 = Person("sumit",120)
p2.weightInPounds
p2.weightInKilos
/*
 Both property call identical but
  def evaluate each time, val evaluate once
*/