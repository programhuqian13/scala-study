//进行while语法归类
//while和do-while结构称为循环，而不是表达式，因为它们不会产生有趣的值。
//结果的类型是Unit。事实证明，存在一个类型为Unit的值(实际上只有一个值)。
//它被称为单位值，名为()。()的存在是Scala单元不同于Java void的地方
class WhileExpression{

  //while只要条件为真（这里是先判断）的情况就会执行循环，do-while将先运行循环体中的代码，在判断条件
  def gcdLoop(x: Long,y: Long): Long = {
    val a = x
    val b = y
    while(a != 0){
      val temp = a
      a = b % a
      b = temp
    }
    b
  }

  def doWhileMethod(line: String){
    do{
      line = readLine()
      println("Read:" + line)
    }while(line != "")
  }

}
