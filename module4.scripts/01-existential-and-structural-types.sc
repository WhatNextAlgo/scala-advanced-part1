import language.{existentials,reflectiveCalls}
//def lengthOfListOrig(xs:List):Int = xs.size

//using generic
def lengthOfList[T](xs:List[T]):Int = xs.size
lengthOfList(List(1,2,3))

//using named existential

def lengthOfListExistential(xs:List[_]):Int = xs.size
lengthOfListExistential(List(1,2,3))


trait  Food { val name:String}
trait Fruit extends Food
case class Apple(name:String) extends Fruit
val fruits = List(Apple("Fiji"),Apple("Granny Smith"))
def fruitName[T <: Fruit](fruits:List[T]) = fruits.map(_.name)
def fruitName2(fruits:List[_ <: Fruit]) = fruits.map(_.name)

fruitName(fruits)
fruitName2(fruits)

// Structural Types
def maxSizeInSeq(xs:Seq[_ <: {def size:Int}]) = xs.map(_.size).max

case class Person(name:String,age:Int){
  def size = name.length
}
maxSizeInSeq(Seq(
  List(1,2,3),
  List(1,2),
  List(1,2,3,4)
))

maxSizeInSeq(Seq(
  Person("Fred",28),
  Person("Sumit",29)
))

val s= "hello"
val as:Any = s

s.length
//as.length
as.asInstanceOf[{def length:Int}].length