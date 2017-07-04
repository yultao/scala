package tt.lab.spark.streaming

import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Seconds
import org.apache.spark.SparkConf
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.kafka010.LocationStrategies
import org.apache.spark.streaming.kafka010.ConsumerStrategies
import org.apache.spark.streaming.kafka010.KafkaUtils
import com.citi.mirrorlake.common.GenericDataModel
import org.apache.kafka.common.serialization.StringDeserializer
import tt.lab.spark.scala.GDMDeserializer
import tt.lab.spark.scala.Utils

object KafkaStreaming {
  def main(args: Array[String]) {
    Utils.setHadoopHome
    val conf = new SparkConf()
      .setAppName("KafkaStreaming")
      .setMaster("local[*]")
      .set("spark.dynamicAllocation.enabled", "true")
      .set("spark.shuffle.service.enabled", "true")
      .set("spark.sql.inMemoryColumnarStorage.compressed", "true")
      .set("spark.driver.allowMultipleContexts", "true")

    val ss = SparkSession.builder()
//      .master("local[*]")
      .config(conf)
      .getOrCreate();

    val ssc = new StreamingContext(conf, Seconds(3))

    val brokers = "sd-c2d1-ebc1.nam.nsroot.net:9292,sd-41d7-253f.nam.nsroot.net:9292,sd-f54f-6b08.nam.nsroot.net:9292"
//    val brokers = "xx"
    val kafkaParams = Map[String, Object](
      // kafkaParams.put("metadata.broker.list", brokers);
      "group.id" -> "KafkaStreamingGroup",
      "bootstrap.servers" -> brokers,
      "auto.offset.reset" -> "latest",
      "key.deserializer" -> classOf[StringDeserializer],
      "value.deserializer" -> classOf[GDMDeserializer],
      "enable.auto.commit" -> "true");

//    val topics = Array("credit.cache.marketdata.rt.topic")
    val topics = Array("credit.temp.1.ytrewq.topic");
    val stream = KafkaUtils.createDirectStream[String, GenericDataModel](
      ssc,
      LocationStrategies.PreferConsistent,
      ConsumerStrategies.Subscribe[String, GenericDataModel](topics, kafkaParams))

    stream.foreachRDD(genericDataModel => {
      println("Received msg:" + genericDataModel.id+", "+genericDataModel.name+", "+genericDataModel.partitioner+", "+genericDataModel.partitions)
    })

    println("Start SparkStreamContext...")
    ssc.start()
    ssc.awaitTermination()

  }
}