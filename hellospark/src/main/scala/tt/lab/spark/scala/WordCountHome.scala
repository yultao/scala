package tt.lab.spark.scala

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object WordCountHome {
  def main(args: Array[String]) {
    Utils.setHadoopHome
    
//    val sc = new SparkContext("local[*]", "WordCount")
    val conf = new SparkConf().setAppName("WordCount")
    val sc = new SparkContext(conf)
//    val lines = sc.textFile("hdfs://centosa:9000//user/hadoop/wordcount.txt")
    val lines = sc.textFile("/user/hadoop/wordcount.txt")
    println(lines.count())
    println("raw lines: ")
    lines.take(5).foreach { println}
    
    val words = lines.flatMap(x => x.toString().split("\\W+"))
    
    println("\nsplit words:")
    words.take(5).foreach(println)
    
    
//    println("\nword map:")
//    val wordmap = words.map { x => (x,1) }
//    
//    wordmap.take(5).foreach(println)
    val lowercaseWords = words.map(x => x.toLowerCase())
    val wordCounts = lowercaseWords.map(x => (x, 1)).reduceByKey( (x,y) => x + y )
    
    //val wordCounts = words.countByValue()
    
    
    println("\nresults:")
    wordCounts.take(5).foreach(println)


    wordCounts.saveAsTextFile("hdfs://centosa:9000//user/hadoop/wordcount.out")
  }
}