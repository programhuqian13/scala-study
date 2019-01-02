//很多时候我们需要将不同的业务放到不同scala文件中进行处理
//从而进行进一步的进行抽象，抽出来共有的代码，进行相关的封装处理
//当统一个逻辑处理调用的时候只需要调用相关的业务处理单元就可以了
object FileMatcher{

  //定义一个私有变量存放当前目录下面的所有文件
  private def filesHere = (new java.io.File(".")).listFiles
  //查找文件已query结尾的文件
  def filesEnding(query: String) =
    for(file <- filesHere; if file.getName.endsWith(query))
      yield file

  //查询文件名是否包含query
  def fileContaining(query: String) =
    for(file <- filesHere; if file.getName.contains(query))
      yield file

  //使用正则表达式进行匹配
  def fileRegs(query: String) =
    for(file <- filesHere; if file.getName.matches(query))
      yield file

  //有经验的程序员会注意到所有这些重复，并想知道是否可以将其分解成一个通用的帮助函数,但是以上是做不到的
  //函数值提供了一个答案。虽然您不能将方法名作为值传递，但是您可以通过传递为您调用方法的函数值来获得相同的效果
  def filesMatching(query: String,matcher: (String,String) => Boolean)={
    for(file <- filesHere){
      if(matcher(file.getName,query)){
        yield file
      }
    }
  }

  //将上面的方法改为这样的
  def filesEndingMethod(query: String)=
    filesMatching(query, _.endsWith(_))

  def fileContainingMethod(query: String) =
    filesMatching(query, _.contains(_))

  def fileRegsMethod(query: String) =
    filesMatching(query, _.matches(_))




}
