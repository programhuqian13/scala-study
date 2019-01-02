
object ControlAbstractRun{

  def main(args: Array[String]){
    //println("FileMatcher.filesEndingMethod():" + FileMatcher.filesEndingMethod("scala"))
    //检查是否包含负数
    def containsNeg(nums: List[Int]): Boolean = {
      var exists = false
      for(num <- nums)
        if(num < 0)
          exists = true
      exists
    }

    println(containsNeg(List(1,2,-4,2)))

    //用另一种方式实现
    def containsOther(nums: List[Int]): Boolean = nums.exists(_ < 0)
    println(containsOther(List(1,2,-4,2)))

    def plainOldSum(x: Int,y: Int) = x + y
    println("old: " + plainOldSum(1,2))
    //实际上，您会得到两个传统的函数调用。第一个函数调用接受一个名为x的Int参数，
    //并为第二个函数返回一个函数值。第二个函数使用Int参数y
    def plainNewSum(x: Int)(y: Int) = x + y
    println("new: " + plainNewSum(1)(2))

    //定义方法链:局部化过程
    def first(x: Int) = (y: Int) => x + y

    val second = first(1)

    println(second(2))

    val onePlus = plainNewSum(1)_
    println(onePlus(3))

    //定义一个新的控制结构：
    //在函数作为一等公民的语言中，即使语言的语法是固定的，也可以有效地创建新的控制结构。您所需要做的就是创建以函数为参数的方法
    def twice(op: Double => Double,x: Double) = op(op(x))
    println(twice(_ + 1,5))

    def withPrintWriter(file: java.io.File, op: java.io.PrintWriter => Unit){
      val writer = new java.io.PrintWriter(file)
      try{
        op(writer)
      }finally {
        writer.close()
      }
    }
    //使用这种方法的优点是，使用printwriter而不是用户代码可以确保文件在最后关闭。
    //所以不可能忘记关闭文件。这种技术称为贷款模式，因为控件抽象函数(如withPrintWriter)打开资源并将其借给函数
    withPrintWriter(
      new java.io.File("ControlAbstractRun.scala"),
      writer => writer.println(new java.util.Date)
    )
    //参数换名
    var assertionsEnabled = true
    def myAssert(predicate: () => Boolean) = {
      if(assertionsEnabled && !predicate())
        throw new AssertionError
    }

    println(myAssert(() => 5 > 3))
    //如果我调用这个方法的使用下面的情况下回报错 编辑就会报错   type mismatch
      //println(myAssert(5 > 3))
    //By-name参数精确地存在，以便您可以这样做。要创建byname参数，您需要给该参数一个类型，以=>开头，而不是以()=>开头
    def byNameAssert(predicate: => Boolean) =
      if(assertionsEnabled && !predicate)
        throw new AssertionError

    //通过上面的方法是可以直接用如下方法调用
    println(byNameAssert(5 > 3))

    def boolAssert(predicate: Boolean) =
      if(assertionsEnabled && !predicate)
        throw new AssertionError

    println(boolAssert(5>3))

    //然而，这两种方法之间存在一个重要的区别，值得注意。
    //因为boolAssert参数的类型是布尔值，所以在调用boolAssert之前计算boolAssert（5> 3）中括号内的表达式。
    //表达式5> 3产生true，传递给boolAssert。 相反，因为byNameAssert的谓词参数的类型是=> Boolean，
    //所以在调用byNameAssert之前不会计算byNameAssert（5> 3）中括号内的表达式。
    //而是创建一个函数值，其apply方法将计算5> 3，并且此函数值将传递给byAsAssert。
    //因此，两种方法之间的区别在于，如果禁用断言，您将看到括号内的表达式在boolAssert中可能具有的任何副作用，
    //但不会出现在byAsAssert中。

  }

}
