package tt.lab.spark.scala

import org.apache.spark.SparkContext
import java.io.BufferedOutputStream
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.fs.Path

//import java.io.BufferedReader
//import java.io.InputStreamReader
//import util.control.Breaks._
object Utils {
  def setHadoopHome() {
    //    val pb = new ProcessBuilder("CMD.exe", "/C", "SET");
    //    val env = pb.environment;
    //    env.put("HADOOP_HOME", "C:/Dev/winutils");
    //    val process = pb.start();
    //    val in = new BufferedReader(new InputStreamReader(process.getInputStream()));
    //    breakable {
    //        while (true) {
    //          val line = in.readLine
    //          if(line==null) break
    //          println(line);
    //        }
    //    }
    ////    println(env)
    if (System.getenv("HADOOP_HOME") == null)
      System.setProperty("hadoop.home.dir", "C:/Dev/winutils")
  }

  def writeFile(sc: SparkContext, filename: String, content: String) {
    if (filename == null) throw new IllegalArgumentException();
    if(filename.startsWith("file://")){
      writeFileToLocal(sc,filename,content);
    } else if (filename.startsWith("hdfs://")){
      writeFileToHDFS(sc,filename,content);
    } else {
      println("Cannot recognize protocol");
    }
  }
  
  def writeFileToLocal(sc: SparkContext, filename: String, content: String) {
    
  }
  
  def writeFileToHDFS(sc: SparkContext, filename: String, content: String) {
    // Hadoop Config is accessible from SparkContext
    val fs = FileSystem.get(sc.hadoopConfiguration);
    // Output file can be created from file system.
    val output = fs.create(new Path(filename));
    // But BufferedOutputStream must be used to output an actual text file.
    val os = new BufferedOutputStream(output)
    os.write("Hello World".getBytes("UTF-8"))
    os.close()
  }
}