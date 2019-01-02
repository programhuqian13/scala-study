//scala中的方法
import scala.io.Source
object MethodScala{

  //定义一个方法
  def processFile(fileName: String,width: Int): Unit ={
    val source = Source.fromFile(fileName,"UTF-8")
    for(line <- source.getLines())
      processLine(fileName,width,line)
  }

  private def processLine(fileName: String,width: Int, line: String): Unit ={
    if(line.length > width)
      println(fileName + ": " + line)
  }

  //一般在程序中尽量将方法精细化，更容易理解。这样做的话一个对象里面会有多个方法，这些方法都会影响程序的命名空间。
  //在java中可以用private解决，scala中也可以使用私有方法解决。scala提供了另一个机制就是可以在对象函数中定义另外的函数
  def locationFunction(fileName: String,width: Int): Unit = {
    //本地方法
    def locationFunctionLine(fileName: String,width: Int,line: String){
      if(line.length > width)
        println(fileName + ": " + line)
    }
    //读取文件信息
    var source = Source.fromFile(fileName,"UTF-8")
    for(line <- source.getLines)
      locationFunctionLine(fileName,width,line)
  }

}
