import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException
import java.net.URL
import java.net.MalformedURLException

class ExceptionHandlerExpression{

    //抛出异常  不许输入为偶数
    def half(n: Int): Unit =
      if(n % 2 == 0)
        n / 2
      else
        throw new RuntimeException("n must be even")

    //使用try-catch进行异常的使用
    //与Java不同，Scala不需要捕捉检查过的异常，或者在throw子句中声明它们
    def tryCatchEx(): Unit = {
      try{
        val file = new FileReader("exceptionUse.txt");
        println(file)
      }catch{
        case ex: FileNotFoundException => println("不存在相应的文件")//没有相关文件
        case ex: IOException => println("出现IO异常")//其他的IO异常
      } finally{
        file.close()
      }
    }

    def g(): Int =
      try{
        return 1
      }finally{
        return 2
      }

    def f(): Int =
      try{
        1
      }finally{
        2
      }

    def urlFor(path: String) =
      try{
        new URL(path)
      }catch{
        case ex: MalformedURLException =>
          new URL("https://www.baidu.com")
      }

}
