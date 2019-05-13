package main.scala.design_patterns.bridge

trait  Md5Hasher extends Hasher {

  override def hash(data: String): String = new String(getDigest("MD5", data).digest())
}
