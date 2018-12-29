//运行一个scala的应用，必须创建一个单例的对象与一个main方法，接受一个Array[String]的参数，
//并且返回值为Unit的一个方法。和java基本类似，java为public static void main(String [] aegs){}
import CreateObjectTest.calculate

object Summer{
  def main(args: Array[String]){
    for(arg <- args)
      println(arg + " : " + calculate(arg))
  }
}
//Scala隐式地将包java.lang和scala的成员以及名为Predef的单个对象的成员导入到每个Scala源文件中。
//Predef驻留在包scala中，包含许多有用的方法。
//例如，当您在Scala源文件中说println时，实际上是在Predef上调用println。
//（Predef.println转过身来调用Console.println，它完成了真正的工作。）当你说断言时，你正在调用Predef.assert
