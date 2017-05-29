package tt.lab.scala


object HelloScalaWorkSheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(95); 
  println("Welcome to the Scala worksheet");$skip(16); 
  var x:Int = 2;System.out.println("""x  : Int = """ + $show(x ));$skip(16); 
  var y:Int = 3;System.out.println("""y  : Int = """ + $show(y ));$skip(20); 
  var z:Int = x * y;System.out.println("""z  : Int = """ + $show(z ));$skip(17); 
  
  var n_2 =0;System.out.println("""n_2  : Int = """ + $show(n_2 ));$skip(14); ;
  var n_1 =0;System.out.println("""n_1  : Int = """ + $show(n_1 ));$skip(13); ;
  var n = 0;System.out.println("""n  : Int = """ + $show(n ));$skip(167); ;
  for (x <- 0 to 9 ) {
    if (x==0) {
    	n = 0
    } else if(x==1) {
     n = 1;
    } else {
      n = n_2 + n_1;
  	}
  	println(n)
  	n_2 = n_1;
	  n_1 = n;
  };$skip(60); 
	def transformInt(x:Int, f:Int => Int):Int = {
    f(x)
  };System.out.println("""transformInt: (x: Int, f: Int => Int)Int""");$skip(36); 
  
  def cubeIt(x:Int): Int = x*x*x;System.out.println("""cubeIt: (x: Int)Int""");$skip(31); 
  x = transformInt(2, cubeIt);$skip(13); ;
  println(x);$skip(40); 
  
  println(transformInt(2, x=>x*200));$skip(40); 
  
  var alist = List("a", "b", "c, d");System.out.println("""alist  : List[String] = """ + $show(alist ));$skip(22); 
  println(alist.size)}
  
}
