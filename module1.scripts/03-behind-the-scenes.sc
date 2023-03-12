val conversionKilosInPounds = 2.20462262185

class Person(nm:String,wt:Double){
  def name:String = nm
  private[this] var wtIbs = wt

  def weightInPounds:Double = wtIbs

  def weightInPounds_=(newWeight:Double):Unit ={
    wtIbs = newWeight
  }

  def weightInKilos:Double = weightInPounds / conversionKilosInPounds

  def weightInKilos_=(newWeight:Double):Unit = {
    weightInPounds = newWeight * conversionKilosInPounds
  }
}

val fred = new Person("Fred",120)

fred.weightInPounds
fred.weightInKilos

fred.weightInKilos = 60
fred.weightInKilos_=(60)
fred.weightInKilos
fred.weightInPounds

fred.weightInPounds = 120
fred.weightInPounds
fred.weightInKilos