abstract class Food {val name:String}

abstract class Fruit extends Food
case class Orange(name:String) extends Fruit
case class Apple(name:String) extends Fruit
val fuji = Apple("Fuji")

trait Sink[T]{
  def send(item:T):String
}

object AppleSink extends Sink[Apple]{
  override def send(item: Apple): String = s"Coring and eating ${item.name}"
}

object OrangeSink extends Sink[Orange]{
  override def send(item: Orange): String = s"Juicing and drinking ${item.name}"
}
object FruitSink extends Sink[Fruit]{
  override def send(item: Fruit): String = s"Eating a healthy ${item.name}"
}

object AnySink extends Sink[Any]{
  override def send(item: Any): String = s"Sending $item"
}

def sinkAnApple(sink:Sink[Apple]):String = {
  sink.send(Apple("Fuji"))
}

sinkAnApple(AppleSink)

//sinkAnApple(OrangeSink)

//sinkAnApple(FruitSink)

trait Sink2[-T]{
  def send(item:T):String
}

object AppleSink2 extends Sink2[Apple]{
  override def send(item: Apple): String = s"Coring and eating ${item.name}"
}

object OrangeSink2 extends Sink2[Orange]{
  override def send(item: Orange): String = s"Juicing and drinking ${item.name}"
}
object FruitSink2 extends Sink2[Fruit]{
  override def send(item: Fruit): String = s"Eating a healthy ${item.name}"
}

object AnySink2 extends Sink2[Any]{
  override def send(item: Any): String = s"Sending ${item.toString}"
}

def sinkAnApple(sink:Sink2[Apple]):String = {
  sink.send(Apple("Fuji"))
}


sinkAnApple(AppleSink2)
sinkAnApple(FruitSink2)
sinkAnApple(AnySink2)