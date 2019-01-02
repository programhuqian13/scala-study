
object MethodRun{

  def main(args: Array[String]){
    val width = args(0).toInt
    for(arg <- args.drop(1))  //drop 选择除前n个元素之外的所有元素。
      MethodScala.processFile(arg,width)

    //本地方法的使用
    for(arg <- args.drop(1))
      MethodScala.locationFunction(arg,width)

    //函数在scala中是一等公民
    var increase = (x : Int) => x + 1
    println("increase(10):" + increase(10))
    //我们可以给函数添加处理代码块
    var increaseBlock = (x : Int) => {
      println("We")
      println("are")
      println("Here!")
      x + 1
    }
    println("increaseBlock(10):" + increaseBlock(10))

    //list集合的遍历和过滤
    val someNumbers = List(10,2,-12,3,0,-56)
    someNumbers.foreach((x: Int) => println(x))
    //过滤
    println(someNumbers.filter((x: Int) => x > 0))
    //占位符语法:将list中的每一个元素与_进行替换，进行和0进行比较
    println(someNumbers.filter(_ > 0))
    //定义一个方法，使用_进行操作
    val functions = (_: Int) + (_: Int)
    println("functions = (_: Int) + (_: Int):" + functions(1,4))
    //我们打印下面的list中的元素的时候，也可以使用_占位符
    someNumbers.foreach(print _)  //等同于someNumbers.foreach(x =>print(x))

    def sum(a: Int,b: Int,c: Int) = a + b + c
    val result = sum _
    println("sum funtion:" + sum(1,2,3))
    println("result _:" + result(1,2,3))
    println("result apply:" + result.apply(1,2,3)) //这里的apply是和_等价的，这个是scala编译器转换为sum _
    val result2 = sum(1, _: Int,3)
    println("result2 _:" + result2(1))

    //函数的闭包：函数值(对象)是在运行时由这个函数文字创建的，称为闭包
    val closeVal = 3;
    someNumbers.foreach((x : Int) => println("x+closeVal:" + (x + closeVal)))

    //Scala允许您指出函数的最后一个参数可能是重复的。
    //这允许客户端将可变长度的参数列表传递给函数。若要表示重复参数，请在参数类型后面加星号
    def echo(args: String*) =
      for(arg <- args) println(arg)
    //边长参数 这里和java中的可变长参数使用差不多 String ... args
    echo("Hello","world")  //这个方法不能传递一个Array[String]，如果需要传递一个Array,改为如下方式
    echo(args: _*)

    //重命名参数
    def namedParam(total: Float,time: Float): Float =
      total/time

    //调用参数的方式
    println(namedParam(100,10))
    println(namedParam(total = 100,time = 10))
    println(namedParam(time = 10,total = 100))
    //改相关参数设置默认值
    //Scala允许为函数参数指定默认值。
    //可以从函数调用中选择性地省略此类参数的参数，在这种情况下，相应的参数将用默认值填充
    def printTime(out: java.io.PrintStream = (Console.out)) =
      out.println("time = " + System.currentTimeMillis())

    printTime()  //如果你这个参数不传的话，默认的out将会是Console.out
    printTime(Console.err)

    def printTime2(out: java.io.PrintStream = (Console.out),param2: Int = 3) =
      out.println("time = " + System.currentTimeMillis() + " param2: " + param2)

    printTime2()  //不传参数将会使用默认的参数
    printTime2(Console.err)
    printTime2(param2 = 4)

    //递归的使用：递归就是方法自己调用自己
    //尾部调用优化为近似编译的代码本质上与为近似循环编译的代码相同
    //下面代码不是尾部递归，因为它在递归调用之后执行递增操作
    def boom(x : Int) : Int =
      if(x == 0) throw new Exception("Boom!")
      else boom(x -1) + 1

    boom(3)
    //利用编译命令scalac 后面添加-g:notailcalls关闭
    def bang(x : Int) : Int =
      if(x == 0) throw new Exception("Bang!")
      else bang(x -1)

    bang(4)

    def nestedFun(x : Int){
      if(x != 0){
        println(x);
        funValue(x - 1)
      }
    }
    val funValue = nestedFun _
  }
}
