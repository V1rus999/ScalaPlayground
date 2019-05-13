package main.scala.design_patterns.bridge

class SaltedPasswordConverter(salt: String, hasher: Hasher) extends PasswordConverter(hasher) {
  override def convert(password: String): String = hasher.hash(s"$salt:$password")
}
