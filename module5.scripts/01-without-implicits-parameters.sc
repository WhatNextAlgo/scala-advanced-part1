case class RetryParams(times:Int)
import scala.util.control.NonFatal
def retryCall[A](fn: => A,currentTry:Int = 0)(retryParams: RetryParams):A = {
  try fn
  catch {
    case NonFatal(_) if currentTry  < retryParams.times =>
      retryCall(fn, currentTry + 1)(retryParams)
  }
}

def retry[A](fn: => A)(retryParams: RetryParams):A = {
  retryCall(fn,0)(retryParams)
}

var x = 0
def checkIt():Int = {
  x = x + 1
  println(s"checking ${x}")
  require(x > 4,"x not big enough")
  x
}

retry(checkIt())(RetryParams(5))

retry{
  println("trying")
  checkIt()
}(RetryParams(5))
