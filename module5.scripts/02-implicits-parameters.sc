case class RetryParams(times:Int)
import scala.util.control.NonFatal
def retryCall[A](fn: => A,currentTry:Int = 0)(implicit retryParams: RetryParams):A = {
  try fn
  catch {
    case NonFatal(_) if currentTry  < retryParams.times =>
      retryCall(fn, currentTry + 1)(retryParams)
  }
}

def retry[A](fn: => A)(implicit retryParams: RetryParams):A = {
  retryCall(fn,0)(retryParams)
}

implicit val retries:RetryParams = RetryParams(5)

var x = 0
def checkIt():Int = {
  x = x + 1
  println(s"checking ${x}")
  require(x > 4,"x not big enough")
  x
}
retry{
  checkIt()
}

import scala.concurrent._
import ExecutionContext.Implicits.global

Future(1)
Future(1)(global)




