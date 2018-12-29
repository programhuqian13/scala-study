//定义一个类
class CreateClassTest {
  //定义相应的类的字段（fileds）
  var sum = 0
  //定义一个私有的变量,在Scala中公开成员的方法是不显式指定任何访问修饰符。
  //换句话说，在Java中你可以说public，而在Scala中你什么都不说。Public是Scala的默认访问级别
  private var privateVar = "this is a private var"

  //定义相关的方法
  def add(str : String): String ={
    privateVar += str
    return privateVar
  }

  def check(str: String): Boolean ={
    if(privateVar.startsWith(str)) true else false
  }

  def checkR(str: String): Boolean = if(privateVar.startsWith(str)) true else false

}

var acc = new CreateClassTest
var csa = new CreateClassTest

acc.sum = 3
//如果这里acc声明为val，不能重新分配一个新的对象
//acc.privateVar = "vister private var error"
//println(acc.privateVar)
//这里将报错，因为privateVar是私有的方法，只能在CreateClassTest类中进行访问
println(csa.add(",Hello world"))
println(csa.check("this"))
println(csa.checkR("this"))
//scala的分号规则
 //对于语句分离的准确规则，它们的工作效果非常简单。
 //简而言之，除非满足下列条件之一，否则将行结尾视为分号：
 //1。有问题的行以单词形式结束，该单词作为语句的结尾不合法，例如句点或中缀运算符 。
 //2.下一行以一个无法启动语句的单词开头。
 //3.该行在括号（...）或括号[...]内结束，因为它们无论如何都不能包含多个语句
