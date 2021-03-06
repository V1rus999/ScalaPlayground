package main.scala.design_patterns.facade

import java.util.Base64

trait DataDecoder {
  protected def decode(data: Array[Byte]): String = new String(Base64.getDecoder.decode(data), "UTF-8")
}
