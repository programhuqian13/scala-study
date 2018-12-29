//定义一个方法，打印所有的启动参数
def printArgs(args : Array[String]): Unit = {
  var i = 0
  while(i < args.length){
    println(args(i))
    i += 1
  }
}

//利用for使用
def printArgsFor(args: Array[String]): Unit = {
  for(arg <- args)
    println(arg)
}

//利用foreach
def printArgsForeach(args: Array[String]): Unit = {
  args.foreach(println)
}

//function mode的使用
def printArgsFunction(args: Array[String]) = args.mkString("\n")

println("使用printArgs函数：" + printArgs(args))
println("使用printArgsFor函数：" + printArgsFor(args))
println("使用printArgsForeach函数：" + printArgsForeach(args))
println("使用printArgsFunction函数：" + printArgsFunction(args))
//这是个方法返回值都为空
