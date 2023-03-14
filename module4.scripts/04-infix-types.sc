class Loves[T1,T2]{
  def describe(l1:T1,l2:T2):String = s"$l1 loves $l2"
}

case class NamedLoves(p1:String,p2:String) extends Loves[String,String]{
  def sayIt:String = describe(p1,p2)
}

case class Person(name:String)
case class PersonLoves(p1:Person,p2:Person) extends  (Person Loves Person) {
  def sayIt:String = describe(p1,p2)
}

def sayItWithRoses(lovers:Person Loves Person) =
  s"Rose are red, violets are blue, I love you so much, I made you both stew. ${lovers.toString}"

sayItWithRoses(PersonLoves(Person("Fred"),Person("Sally")))