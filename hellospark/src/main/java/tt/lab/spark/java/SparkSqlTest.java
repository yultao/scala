package tt.lab.spark.java;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class SparkSqlTest {
//	val sparkSession = SparkSession.builder
//	  .master("local")
//	  .appName("my-spark-app")
//	  .config("spark.some.config.option", "config-value")
//	  .getOrCreate()
	public static void main(String[] args) {
		SparkSession session = SparkSession.builder()
		  .master("local")
		  .appName("my-spark-app")
		  .config("spark.some.config.option", "config-value")
		  .getOrCreate();
		
		Dataset<Row> json = session.read().json("data/person.json");
		System.out.println(json);
		System.out.println(json.select("id"));
	}
}
