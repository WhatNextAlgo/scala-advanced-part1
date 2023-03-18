val intNum = implicitly[Numeric[Int]]
intNum.times(5,8)

val doubleNum = implicitly[Numeric[Double]]
doubleNum.times(5.0,8.0)

case class Cell[T](item:T){
  def *[U: Numeric](other:Cell[U])(implicit ev:T =:= U):Cell[U] ={
    val numClass = implicitly[Numeric[U]]
    Cell(numClass.times(this.item,other.item))

  }
}

val stringCell = Cell("hello")
val intCell = Cell(10)
//intCell * stringCell

intCell * Cell(5)

