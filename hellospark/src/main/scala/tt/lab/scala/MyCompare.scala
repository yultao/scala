package tt.lab.scala

class MyCompare [T: Ordering] (val a: T, val b: T){
  def max(implicit ordered:Ordering[T]) = if(ordered.compare(a, b)>0) a else b
}

object MyCompare {
  def main(args: Array[String]){
    val mc = new MyCompare[Int](2,4);
    println(mc.max)
  }
}