package tt.lab.scala

object HelloObject {
  def main(args: Array[String]){
    println("Hello Object")
  }
  
  def transformInt(x:Int, f:Int => Int):Int = {
    f(x)
  }
  eclipse.buildId=4.6.3.M20170301-0400
java.version=1.8.0_131
java.vendor=Oracle Corporation
BootLoader constants: OS=win32, ARCH=x86_64, WS=win32, NL=en_CA
Framework arguments:  -product org.eclipse.epp.package.jee.product
Command-line arguments:  -os win32 -ws win32 -arch x86_64 -product org.eclipse.epp.package.jee.product

org.eclipse.equinox.p2.transport.ecf
Error
Sun Jun 04 21:14:03 EDT 2017
Unable to connect to repository http://download.scala-ide.org/sdk/lithium/e44/scala211/stable/site/content.xml

}