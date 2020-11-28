package tt.lab.scala

import scala.io.Source

class ImageSummary {

}
object ImageSummary {
  def main(args: Array[String]) {
    println("Image Summary");
    val filename = "test.txt"
//    for (line <- Source.fromFile(filename).getLines) {
//      println(line)
//    }
    
    Source.fromFile(filename).getLines.foreach { println }
  }
}