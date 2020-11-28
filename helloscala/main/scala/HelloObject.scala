package tt.lab.scala

object HelloObject {
  def main(args: Array[String]){
    println("Hello Object")
  }
  
  def transformInt(x:Int, f:Int => Int):Int = {
    f(x)
  }


}