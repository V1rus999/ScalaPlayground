package main.scala.design_patterns.bridge

abstract class PasswordConverter(hasher: Hasher) {
  def convert(password: String): String
}
