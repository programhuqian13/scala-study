
object ExceptionHandlerRun{

  def main(args: Array[String]){
    val exceptionHandlerExpression = new ExceptionHandlerExpression()
    exceptionHandlerExpression.half(4)   //将不抛出异常
    exceptionHandlerExpression.half(3)  //将抛出必须为偶数的异常
    //try-catch进行异常的使用
    exceptionHandlerExpression.tryCatchEx()
  }

}
