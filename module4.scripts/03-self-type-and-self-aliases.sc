// self aliases
case class Person(name:String){ outer =>
  case class LifePartner(name:String){
    def describe:String = s"${this.name} loves ${outer.name}"
  }
}

val p1 = Person("Fred")
val p2 = p1.LifePartner("Sally")
p2.describe

// self types with requirements

trait LazyLogging {
  def error(er:String) = er

}
trait Loves {this:LazyLogging =>
def loves(l1:AnyRef,l2:AnyRef) = error(s"$l1 loves $l2")
}


case class Lovers(name1:String,name2:String) extends Loves with LazyLogging {
  def describe:String = loves(name1,name2)
}

Lovers("Fred","Sally").describe