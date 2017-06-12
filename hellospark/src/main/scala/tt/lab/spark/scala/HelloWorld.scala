package tt.lab.spark.scala

import org.apache.spark.SparkContext

object HelloWorld {
  def main(args: Array[String]) {
    Utils.setHadoopHome
    val sc = new SparkContext("local[*]", "HelloWorld")   
//    val rdd = sc.textFile("s3n://sundog-spark/ml-1m/ratings.dat")

    val html = scala.io.Source.fromURL("http://gxslnx16p.nam.nsroot.net:30075/streamFile/user/nelly/cva_dva_analytics/cva_scenario_output/cob=20170605/scenario=DLY_CPTY/000000_0?nnaddr=169.185.215.207:30890")
    println(html)
//    val list = html.split("\n").filter(_ != "")
//    val rdd = sc.parallelize(html)
//    
//    val count = rdds.filter(_.contains("Spark")).count()
//    val rdd = sc.textFile("C:/Dev/spark-2.1.1-bin-hadoop2.7/README.md")
//    println(rdd)
//     val words = rdd.flatMap { x => x.split(" ") }
//    words.foreach { println }
    
  }
}