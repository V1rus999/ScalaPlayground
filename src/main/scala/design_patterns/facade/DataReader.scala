package main.scala.design_patterns.facade

class DataReader extends DataDownloader with DataDecoder with DataDeserializer {

  def getData(url: String): Data = {
    val rawData = download(url)
    val json = decode(rawData)
    parse(json)
  }
}
