case class Complex(real:Double,imaginary:Double= 0.0){
  override def toString: String = s"$real $sign ${imaginary.abs}i"
  private def sign = if (imaginary >=  0.0)  "+" else "-"

  def +(other:Complex) =
    Complex(real + other.real, imaginary + other.imaginary)
}

object Complex {
  implicit def intToComplex(i:Int):Complex = Complex(i)
}

val c1 = Complex(5,6)
val c2 = Complex(-3,-6)
c1 + c2
c1 + 6
6 + c1

implicit class TimesInt(i:Int){
  def times(fn: => Unit):Unit = {
    var x = 0
    while (x < i){
      x += 1
      fn
    }
  }
}

5 times {println("hello")}


// try to run in source code
//implicit class TimesInt(val i:Int) extends AnyVal {
//  def times(fn: => Unit):Unit = {
//    var x = 0
//    while (x < i){
//      x += 1
//      fn
//    }
//  }
//}