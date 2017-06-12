package tt.lab.spark.scala

import org.apache.spark.sql.SparkSession


object Hive {
  def main(args: Array[String]) {

    Utils.setHadoopHome

    val session = SparkSession.builder
      .master("local")
      .appName("my-spark-app")
      .config("spark.some.config.option", "config-value")
      .config("spark.sql.warehouse.dir", "file:///C:/GT") // Necessary to work around a Windows bug in Spark 2.0.0; omit if you're not on Windows.
      .getOrCreate();

    val json = session.read.json("data/person.json");

    json.printSchema

    json.show()

  }
}