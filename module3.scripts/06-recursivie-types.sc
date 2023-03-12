trait CompareT[T]{
  def <(other:T):Boolean
  def >(other:T):Boolean
}

def genInsert[T <: CompareT[T]](item:T, rest:List[T]):List[T] = {
  rest match {
    case Nil => List(item)
    case head :: _ if (item < head) => item :: rest
    case head :: tail => head :: genInsert(item,tail)
  }
}

def genSort[T<: CompareT[T]](xs:List[T]):List[T] = xs match {
  case Nil => Nil
  case head :: tail => genInsert(head,genSort(tail))
}

case class Distance(meters:Int) extends CompareT[Distance]{
  override def <(other: Distance): Boolean = this.meters < other.meters
  override def >(other: Distance): Boolean =this.meters > other.meters

}

val dLists = List(Distance(31),Distance(2),Distance(20),Distance(4))
genSort(dLists)

case class EngineSize(ci:Int) extends CompareT[EngineSize]{
  override def <(other: EngineSize): Boolean = this.ci < other.ci
  override def >(other: EngineSize): Boolean =this.ci > other.ci

}
val eLists = List(EngineSize(313),EngineSize(242),EngineSize(2022),EngineSize(4343))
genSort(eLists)

case class Person(first:String,last:String,age:Int) extends CompareT[Person]{
  override def <(other: Person): Boolean = this.age < other.age
  override def >(other: Person): Boolean =this.age > other.age

}

val pLists = List(Person("sumit","maurya",29),Person("rahul","pal",19),Person("mihir","surti",25))
genSort(pLists)