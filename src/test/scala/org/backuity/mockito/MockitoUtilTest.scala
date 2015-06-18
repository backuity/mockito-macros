package org.backuity.mockito

import org.backuity.matchete.JunitMatchers
import org.backuity.mockito.MockitoUtilTest.{Service, Person}
import org.junit.Test
import org.mockito.Mockito
import shapeless.HNil
import MockitoUtil._

class MockitoUtilTest extends JunitMatchers {

  @Test
  def testCaptureAll(): Unit = {
    val service = Mockito.mock(classOf[Service])
    service.call("toto", 12, Person("john", 23))

    val (param1, param2, param3) = captureAll[String :: Int :: Person :: HNil](service.call(captor, captor,captor))

    param1 must_== "toto"
    param2 must_== 12
    param3 must_== Person("john", 23)
  }

  @Test
  def testCapture(): Unit = {
    val service = Mockito.mock(classOf[Service])
    service.call("toto", 12, Person("john", 23))

    val param3 = capture[Person](service.call(any, any, captor))

    param3 must_== Person("john", 23)
  }

}

object MockitoUtilTest {

  case class Person(name: String, age: Int)

  trait Service {
    def call(param1: String, param2: Int, param3: Person)
  }
}
