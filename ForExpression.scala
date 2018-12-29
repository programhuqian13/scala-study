//for循环使用
class ForExpression{

  //得到文件列表，并遍历打印文件
  def forFiles(): Unit = {
    val fileHere = (new java.io.File(".")).listFiles
    for(file <- fileHere)
      println("file:" + file)
  }

  def forFileIndex(): Unit = {
    val fileHere = (new java.io.File(".")).listFiles
    for(i <- 1 to fileHere.length - 1)
      println("fileHereIndex:" + fileHere(i) +" " + i)
  }

  //进行过滤filter 不同的形式
  def forFileFilter(): Unit = {
    val fileHere = (new java.io.File(".")).listFiles
    for(file <- fileHere if file.getName.endsWith(".scala"))
      println("forFileFilter:" + file)
  }

  def forFileFilter2(): Unit = {
    val fileHere = (new java.io.File(".")).listFiles
    for(file <- fileHere)
      if(file.getName.endsWith(".scala"))
        println("forFileFilter2:" + file)
  }

  def forFileFilter3(): Unit = {
    val fileHere = (new java.io.File(".")).listFiles
    for(
      file <- fileHere
      if file.isFile
      if file.getName.endsWith(".scala")
    )println("forFileFilter3:" + file)
  }

  //查询文件中的内容
  def fileLines(file: java.io.File) =
    scala.io.Source.fromFile(file,"UTF-8").getLines().toList

  //管道  过滤相关的字符串
  def grep(pattern: String) = {
    //遍历当前目录下面所有的文件
    val filesHere = (new java.io.File(".")).listFiles
    //遍历所有的文件
    for(file <- filesHere){
      //比较文件名是否已.scala结尾
      if(file.getName.endsWith(".scala")){
        //读取相关文件为文件内容
        for(line <- fileLines(file)){
          //将文件的内容去除空格并查询内容里面有pattern的文件
          if(line.trim.matches(pattern)){
            println(file + ": " + line.trim)
          }
        }
      }
    }
  }

  //定义多个变量(stream变量)
  def grep2(pattern: String) = {
     val filesHere = (new java.io.File(".")).listFiles
     for(file <- filesHere){
       if(file.getName.endsWith(".scala")){
         for(line <- fileLines(file)){
           //定义一个变量保存文件的内容
           val trimmed = line.trim
           if(trimmed.matches(pattern)){
             println(file + ": " + trimmed)
           }
         }
       }
     }
  }

  //上面的循环中，都是执行了循环之后，就会清除所有元素，但是有时候我们需要将去记住，供其他使用 我们需要使用yield关键字

}
