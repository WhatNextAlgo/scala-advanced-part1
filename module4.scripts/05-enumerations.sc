object Color extends  Enumeration{
  val Red,Green, Yellow, Blue = Value
}

var x = 0

def nextX:Int ={
  x += 1
  x -1
}

val a,b,c = nextX

Color.values

object Size extends Enumeration{
  val S = Value(1,"Small")
  val M = Value(2,"Medium")
  val L = Value(3,"Large")
  val XL = Value(4,"Extra Large")
}


def shirt(color:Color.Value, size:Size.Value) = {
  s"A nice Hawaiian shirt, color $color and size $size"
}

shirt(color = Color.Red,size=Size.XL)