object ScalaControlStructures{
  val fileName = "default.txt"
  //scala的程序入口
  def main(args: Array[String]){
    //if语句
    val ifExpression = new IfExpression()
    println("main if expression:" + ifExpression.check(args))

    println("这是直接在方法里面进行if语句：" + (if(!args.isEmpty) args(0) else "default.txt"))

    //for循环的使用
    val forExperssion = new ForExpression()
    forExperssion.forFiles()
    //to是包含4的
    for(i <- 1 to 4)
      println("forindex:" + i)

    //until 不包含4
    for(i <- 1 until 4)
      println("foruntilindex:" + i)

    //进行文件遍历
    forExperssion.forFileIndex()
    //进行filter过滤文件
    forExperssion.forFileFilter()
    forExperssion.forFileFilter2()
    forExperssion.forFileFilter3()

    //grep 管道查询相关字符
    forExperssion.grep(".*gcd.*")
    forExperssion.grep2(".*gcd.*")

    //使用match表达式
    val firstArg = if(args.length > 0) args(0) else ""

    firstArg match {
      case "tony" => println("love")
      case "love" => println("scala")
      case "name" => println("huqian")
      case _ => println("huh?")
    }

    val firstArgFriend = if(!args.isEmpty) args(0) else ""

    val friend =
      firstArgFriend match {
        case "love" => "scala"
        case "tony" => "love"
        case "name" => "huqian"
        case _ => "huhs?"
      }
    println("friend:" + friend)

    //scala中没有continue和break关键字
    var i = 0
    var fountIt = false
    while(i < args.length && !fountIt){
      if(!args(i).startsWith("-")){
        if(args(i).endsWith(".scala")){
          fountIt = true
          println("i:" + i)
        }
      }
      i = i + 1
    }

    searchFrom(0,args)

    //如果在特定的场合必须要使用break的话，可以导入scala的Breaks类，这个类在scala.util.control
    //这个类提供了一个break的方法
    // val input = new BufferedReader(new InputStreamReader(System.in))
    // breakable{
    //   while(true)
    //     println("? ")
    //     if(input.readLine() == "")
    //       break
    // }

    //变量的作用域
    printMutilTable()
    muiltTable()
  }

  def searchFrom(idx: Int,args: Array[String]): Unit =
    if(idx >= args.length) println("idx:" + -1)
    else if (args(idx).startsWith("-"))
      searchFrom(idx + 1,args)
    else if (args(idx).endsWith(".scala"))
      println("idx:" + idx)
    else
      searchFrom(idx + 1,args)

  //在同一个作用域中，只能有一个变量名相同  如果在一个作用域中使用了多个相同的变量名，将编译失败
  //在不同的作用域使用同样的变量名称，是可以通过的 取值的时候就近取值
  def printMutilTable(){
    var i = 1  //仅仅在这个作用域有用
    while(i <= 10){
      var j = 1  //i和j在这个作用域有用
      while(j <= 10){
        val prod = (i * j).toString  //i和j和prod在这个作用域有用
        var k = prod.length //i和j和prod和k在这个作用域有用
        while(k < 4){
          print(" ")
          k += 1
        }
        print(prod)
        j += 1
      }
      println()
      i += 1
    }
  }

  //返回一个序列
  def makeRowSeq(row: Int) =
    for(col <- 1 to 10) yield{
      val prod = (row * col).toString
      val padding = " " * (4 - prod.length)
      padding + prod
    }


  def makeRow(row: Int) = makeRowSeq(row).mkString

  def muiltTable() = {
    val tableSeq =
      for(row <- 1 to 10)
      yield makeRow(row)

    tableSeq.mkString("\n")
  }

}
