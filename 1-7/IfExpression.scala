//if语句
class IfExpression(){

  var fileName = "default.txt"
  //如果参数不为空的时候，将第一项给fileName
  def check(args: Array[String]): String=
    if(!args.isEmpty) args(0) else fileName

  println("fileName:" + fileName)
}
