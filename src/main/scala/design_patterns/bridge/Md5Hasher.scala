package main.scala.design_patterns.bridge

class Md5Hasher extends Hasher {

  override def hash(data: String): String = new String(getDigest("MD5", data).digest())
}
