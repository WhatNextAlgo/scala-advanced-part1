// A field or parametric field like val foo:Int = 0 get re-written to:
private[this] val _foo:Int = 0
def foo:Int = _foo

// for var bar:Int = 0, get written to:
private[this] var _bar:Int = 0
def bar:Int = _bar
def bar_=(d:Int):Unit = {_bar = d}

