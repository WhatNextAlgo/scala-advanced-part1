import scala.reflect._
val s:String = "hello"
classOf[String]
val stringClassTag = classTag[String]

def getClassTag[T:ClassTag](x:T):ClassTag[T] = classTag[T]

val intCT = getClassTag(10)
intCT.runtimeClass

getClassTag("hello").runtimeClass

val intArr = intCT.newArray(5)
getClassTag("hello").newArray(5)

def isA[T:ClassTag](x:Any):Boolean = x match {
  case _ : T => true
  case _ => false
}

isA[Int](7)
isA[Int]("hello")
isA[Map[String,Int]](List(1,2,3))
isA[Map[String,Int]](Map("one" -> 1))
isA[Map[String,Int]](Map("one" -> "1"))



