package main.scala.design_patterns.facade

trait DataDownloader {
  protected def download(url: String): Array[Byte] = {
    "InsgXCJuYW1lXCIgOiBcIkpvaG5cIiB9".getBytes()
  }
}
