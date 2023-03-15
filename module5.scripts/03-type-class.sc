import scala.annotation.implicitNotFound
@implicitNotFound("You need to define a CompareT for ${T}")
abstract class CompareT[T]{
  def isSmaller(l1:T,l2:T):Boolean
  def isLarger(l1:T,l2:T):Boolean
}

def genInsert[T](item:T,rest:List[T])(implicit compare: CompareT[T]):List[T] = {
  rest match {
    case Nil => List(item)
    case head :: _ if compare.isSmaller(item,head) => item :: rest
    case head :: tail => head :: genInsert(item,tail)
  }
}

def genSort[T](xs:List[T])(implicit compare: CompareT[T]):List[T] = xs match {
  case Nil => Nil
  case head :: tail => genInsert(head,genSort(tail))
}

implicit object CompareInt extends CompareT[Int] {
  override def isSmaller(l1: Int, l2: Int): Boolean = l1 < l2
  override def isLarger(l1: Int, l2: Int): Boolean = l1 > l2
}


val nums = List(1,5,3,4)
genSort(nums)

case class Distance(meters:Int)
implicit def CompareDistance:CompareT[Distance]  = new CompareT[Distance] {
  override def isSmaller(l1: Distance, l2: Distance): Boolean = l1.meters < l2.meters
  override def isLarger(l1: Distance, l2: Distance): Boolean = l1.meters > l2.meters
}

genSort(List(Distance(343),Distance(42),Distance(411),Distance(23)))


case class Person(name:String,age:Int)

implicit val ComparePerson:CompareT[Person] = new CompareT[Person] {
  override def isSmaller(l1: Person, l2: Person): Boolean = l1.age < l2.age
  override def isLarger(l1: Person, l2: Person): Boolean = l1.age > l2.age
}

genSort(List(Person("Fred",343),Person("John",42),Person("Smith",411),Person("Morris",23)))

