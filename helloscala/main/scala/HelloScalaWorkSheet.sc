package tt.lab.scala


object HelloScalaWorkSheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  var x:Int = 2                                   //> x  : Int = 2
  var y:Int = 3                                   //> y  : Int = 3
  var z:Int = x * y                               //> z  : Int = 6
  
  var n_2 =0;                                     //> n_2  : Int = 0
  var n_1 =0;                                     //> n_1  : Int = 0
  var n = 0;                                      //> n  : Int = 0
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
  }                                               //> 0
                                                  //| 1
                                                  //| 1
                                                  //| 2
                                                  //| 3
                                                  //| 5
                                                  //| 8
                                                  //| 13
                                                  //| 21
                                                  //| 34
	def transformInt(x:Int, f:Int => Int):Int = {
    f(x)
  }                                               //> transformInt: (x: Int, f: Int => Int)Int
  
  def cubeIt(x:Int): Int = x*x*x                  //> cubeIt: (x: Int)Int
  x = transformInt(2, cubeIt);
  println(x)                                      //> 8
  
  println(transformInt(2, x=>x*200))              //> 400
  
  var alist = List("a", "b", "c, d")              //> alist  : List[String] = List(a, b, c, d)
  println(alist.size)                             //> 3
  
}