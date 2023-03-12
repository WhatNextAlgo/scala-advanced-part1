case class Distance(meters:Int){
  def larger(other:Distance):Distance =
    if (other.meters > this.meters) other else this

  def smaller(other:Distance):Distance =
    if (other.meters < this.meters) other else this

  def >(other: Distance): Boolean = this.meters > other.meters
  def <(other: Distance): Boolean = this.meters < other.meters

}

val d1 = Distance(10)
val d2 = Distance(20)
d1 > d2
d1 < d2

d1 larger d2
d1 smaller d2

def insertDistance(item:Distance, rest:List[Distance]):List[Distance] =
  rest match{
    case Nil => List(item)
    case head :: _ if (item < head) => item :: rest
    case head :: tail => head :: insertDistance(item,tail)
  }

def sortDistances(xs:List[Distance]):List[Distance] = xs match{
  case Nil => Nil
  case head :: tail => insertDistance(head,sortDistances(tail))
}

sortDistances(List(Distance(19),Distance(12),Distance(1),Distance(20)))