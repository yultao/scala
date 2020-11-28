spark-submit --class tt.lab.spark.java.WordCountTask --master local[2] hellospark-0.0.1-SNAPSHOT.jar

spark-submit --class tt.lab.spark.java.WordCountTask --master yarn ./target/hellospark-0.0.1-SNAPSHOT.jar
pause