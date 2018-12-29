//Scala比Java更面向对象的一种方式是Scala中的类不能有静态成员。
//相反，Scala有单例对象。单例对象定义看起来像类定义，只不过您使用关键字object而不是关键字class
import scala.collection.mutable.Map

class CreateObjectTest{
  private var sum = 0
  def checksum(): Int = ~(sum & 0xFF) + 1
  def add(b: Byte){sum += b}
}

object CreateObjectTest{
  private val cache = Map[String, Int]()
  def calculate(str: String): Int=
    if(cache.contains(str))
      cache(str)
    else{
      val acc = new CreateObjectTest
      for(c <- str)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (str -> cs)
      cs
    }
}
//当单例对象与类共享相同的名称时，它被称为类CreateObjectTest的companion对象。
//您必须在同一个源文件中定义类及其附属对象。
//该类被称为singleton对象的companion类。类和它的companion对象可以相互访问其私有成员
//println(CreateObjectTest.calculate("hello world tony single object"))
//然而，单例对象不仅仅是静态方法的持有者。它是一级对象。因此，可以将单例对象的名称看作是附加到该对象的名称标记
//定义单例对象并不定义类型(在Scala抽象级别)。
//给定对象checksum累加器的定义，就不能创建checksum累加器类型的变量。
//相反，名为CreateObjectTest的类型是由singleton对象的companion类定义的。然而，单例对象扩展了一个超类，并且可以混合特征
//类和单例对象之间的一个区别是单例对象不能接受参数，而类可以。因为不能用new关键字实例化单例对象，
//所以无法向其传递参数。每个单例对象都是作为一个从静态变量引用的合成类的实例实现的，
//因此它们具有与Java静态相同的初始化语义。特别是，单例对象是在一些代码第一次访问它时初始化的。
//一个单例对象不与一个类共享相同的名称，称为独立对象
