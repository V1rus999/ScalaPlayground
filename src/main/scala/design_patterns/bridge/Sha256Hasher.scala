package main.scala.design_patterns.bridge

import java.security.MessageDigest

class Sha256Hasher extends Hasher {

  override def hash(data: String): String = new String(getDigest("SHA-256", data).digest())
}
