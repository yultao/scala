package tt.lab.scala.spark
import org.apache.spark.sql.SparkSession

object Hive {
  def main(args: Array[String]) {
//    val pb= new ProcessBuilder("export MY_ENV_VAR=1");
//    val env = pb.environment;
//    env.put("HADOOP_HOME", "C:\\Dev\\winutils");
//    println(env)
    
    
    println("Hive")
    
    val session = SparkSession.builder
		  .master("local")
		  .appName("my-spark-app")
		  .config("spark.some.config.option", "config-value")
		  .getOrCreate();
		
		val json = session.read.json("data/person.json");
		println(json.getClass)
//		json.printSchema

		println(json.select("id"));
  }
}