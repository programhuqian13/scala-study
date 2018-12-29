object RationalRun extends App{

  val oneHalf = new Rational(1,2)
  val twoThirds = new Rational(2,3)
  println("oneHalf:" + oneHalf)
  println("twoThirds:" + twoThirds)
  println("new Rational(1,2):" + new Rational(1,2))
  // println("分母不能为0：" + new Rational(5,0))  //这里将抛出一个错误：java.lang.IllegalArgumentException: requirement failed
  println("oneHalf add twoThirds:" + (oneHalf add twoThirds))
  //获取相应的字段信息
  println("oneHalf.numer:" + oneHalf.numer)
  println("oneHalf.denom:" + oneHalf.denom)
  //比较oneHalf和twoThirds的大小，this就是oneHalf that就是传过去的参数 twoThirds
  println("oneHalf max twoThirds:" + oneHalf.max(twoThirds))
  println("辅助构造函数的使用：" + new Rational(5))
  //定义私有变量和方法
  println("定义私有变量和方法:" + new Rational(66,42))

  //定义操作方法
  val x = new Rational(12,5)
  val y = new Rational(4,3)
  println("进行+操作：" + (x + y)) //相当于x.+(y)
  println("进行*操作：" + (x * y))  //相当于x.*(y)
  println("进行方法重载 x*2：" + (x * 2))
  println("进行隐式转换：" + (2 * x))
}
