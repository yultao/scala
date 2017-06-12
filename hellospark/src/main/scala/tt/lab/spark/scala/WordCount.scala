package tt.lab.spark.scala

import org.apache.spark.SparkContext

object WordCount {
  def main(args: Array[String]) {
    Utils.setHadoopHome
    val sc = new SparkContext("local[*]", "WordCount")
    val lines = sc.textFile("data/wordcount.txt")
    println(lines.count())
    println("raw lines: ")
    lines.take(5).foreach { println}
    
    val words = lines.flatMap(x => x.toString().split("\\W+"))
    
    println("\nsplit words:")
    words.take(5).foreach(println)
    
    
    println("\nword map:")
    val wordmap = words.map { x => (x,1) }
    
    wordmap.take(5).foreach(println)
    
    val wordCounts = words.countByValue()
    
    
    println("\nresults:")
    wordCounts.take(5).foreach(println)


    println(wordCounts.take(2).mkString(","))
    
    
  }
}