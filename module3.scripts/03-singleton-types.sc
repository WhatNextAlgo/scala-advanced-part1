val s = "hello"
def say(hello:s.type ):Unit = println(hello)

say(s)

val or ="or"
val to = "to"

object To {
  def be(o:or.type) = this
  def not(t: to.type ) = this
  def be:String = "That is a question"
}

To.be(or).not(to).be

To.not(to).be(or).be