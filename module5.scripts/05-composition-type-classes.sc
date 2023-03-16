trait JSONWrite[T]{
  def toJsonString(item:T):String
}

def jsonify[T:JSONWrite](item:T):String ={
  implicitly[JSONWrite[T]].toJsonString(item)
}

implicit object StrJsonWrite extends JSONWrite[String] {
  override def toJsonString(item: String): String = s""""$item""""
}
implicit object IntJsonWrite extends JSONWrite[Int]{
  override def toJsonString(item: Int): String = item.toString
}

implicit object DoubleJsonWrite extends JSONWrite[Double]{
  override def toJsonString(item: Double): String = item.toString
}

implicit object BooleanJsonWrite extends JSONWrite[Boolean]{
  override def toJsonString(item: Boolean): String = item.toString
}

jsonify("hello")
jsonify(20)
jsonify(20.6)

implicit def listJSONWrite[T:JSONWrite]:JSONWrite[List[T]] = new JSONWrite[List[T]]{
  override def toJsonString(item: List[T]): String = {
    item.map(x => jsonify(x)).mkString("[", ", " ,"]")
  }
}

jsonify(List(1,2,3))
jsonify(List("Hello","World"))
jsonify(List(1.4,2.5,3.6))
jsonify(List(true,false))

implicit def mapJSONWrte[T:JSONWrite]:JSONWrite[Map[String,T]] = new JSONWrite[Map[String, T]]{
  override def toJsonString(item: Map[String, T]):String = {
    val pairs = for ((k,v) <- item) yield s"${jsonify(k)}: ${jsonify(v)}"

    pairs.mkString("{\n ", ",\n "," \n")
  }
}

jsonify(Map("one" -> 1, "two" -> 2))
jsonify(Map(
  "hello" -> List("Hello","World"),
  "goodbye" -> List("goodbye","cruel","world")))