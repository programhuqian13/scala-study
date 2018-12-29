//scala提供了一个scala.Application类，为应用的启动类，只要我们继承了这个类之后，就不用写相应的main方法了
import CreateObjectTest.calculate

object FallWinterSpringSummer extends App {
  for(season <- List("fall","Winter","Spring"))
    println(season + " : " + calculate(season))
}
