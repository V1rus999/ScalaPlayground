package main.scala.design_patterns.bridge

class SaltedPasswordConverter(salt: String) extends PasswordConverterBase {
  self: Hasher =>
  override def convert(password: String): String = hash(s"$salt:$password")
}
