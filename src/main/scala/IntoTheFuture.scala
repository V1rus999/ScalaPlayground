package main.scala

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class IntoTheFuture {

  def doMyLongRunningRequest(request: String): Future[String] = {
    Future {
      Thread.sleep(200)
      request
    }
  }

  // This is a generic function and will return whatever the input function returns.
  def doMyLongRunningFunc[A](function: => A): Future[(A, Double)] = {
    Future {
      val startTime = System.nanoTime
      val result = function
      val stopTime = System.nanoTime
      val diff = stopTime - startTime
      (result, diff / 1000000d)
    }
  }

}
