package main.scala.design_patterns.bridge

abstract class PasswordConverterBase() {
  self: Hasher =>

  def convert(password: String): String
}
