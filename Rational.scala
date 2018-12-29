//创建一个Rational，进行除法计算
//构造一个Rational
//如果一个类没有一个body，你不需要指定空的花括号（虽然你可以，当然，如果你想）。 后面括号中的标识符n和d
//类名Rational称为类参数。 Scala编译器将收集这两个类参数并创建一个主要构造函数,它采用相同的两个参数
//class Rational(n : Int,d: Int)
//scala和java中不一样，构造参数可以直接这样写，java中有构造函数和参数
class Rational(n : Int,d: Int){
  // println("Create " + n + "/" + d)
  //我们作为除法的分母，不能为0，我们可以这样去限制D的值。如果为0的话，将抛出相关的错误信息
  //require方法将返回一个boolean的值，如果返回为true，则可以使用，如果为false将抛出java.lang.IllegalArgumentException: requirement failed的异常
  require(d != 0)
  //定义私有变量和方法 将66/42变为11/7
  private val g = gcd(n.abs,d.abs)
  //定义两个字段
  val numer: Int = n / g
  val denom: Int = d / g
  //这个相当于java中的代码：private int numer; private int denom; public Rational(int n,int d){this.numer=n,this.denom = d}
  //重新去实现toString的方法
  override def toString = numer + "/" + denom
  //定义一个add的方法,如果我们这样访问n和d的时候回报错，因为这两个参数在add方法里面访问不到，
  //我们需要定义两个字段，就像java一样,构造器的方法参数不能用在别的方法上面是一样的道理
  // def add(that: Rational) : Rational = new Rational(n * that.d + that.n * d , d * that.d)
  def add(that: Rational) : Rational
    = new Rational(
        numer * that.denom + that.numer * denom,
        denom * that.denom
    )

  //引用自己：关键字this指的是调用当前正在执行的方法的对象实例，或者在构造函数中使用的对象实例
  //this.numer指调用lessThan的对象的分子。你也可以省略这个前缀，只写numer;这两个符号是等价的
  def lessThan(that: Rational) =
    this.numer * that.denom < that.numer * this.denom

  def max(that: Rational) =
    if(this.lessThan(that)) that else this

  //辅助构造函数
  //有时你需要在一个类中有多个构造函数。 在Scala中，除主要构造函数之外的构造函数称为辅助构造函数
  // 在Scala中，每个辅助构造函数都必须调用另一个构造函数与第一个动作相同的类。
  //换句话说，每一个中的第一个陈述每个Scala类中的辅助构造函数都将具有“this（...）”形式。
  //被调用的构造函数是主构造函数（如在Rational中）示例），或者在文本之前出现的另一个辅助构造函数调用构造函数。
  //这个规则的净效果是Scala中的每个构造函数调用最终都会调用它的主要构造函数类。 因此，主构造函数是类的单个入口点
  //辅助构造函数的定义
  def this(n: Int) = this(n,1)  //这是一个辅助构造函数

  private def gcd(a: Int,b: Int): Int =
    if(b == 0) a else gcd(b,a % b)

  //定义相关的操作
  def +(that: Rational): Rational
    = new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def *(that: Rational): Rational
    = new Rational(
      numer * that.numer,denom * that.denom
    )

  def -(that: Rational): Rational
    = new Rational(
      numer * that.denom - that.numer * denom,
      denom * that.denom
    )

  def /(that: Rational): Rational
    = new Rational(
      numer * that.denom,denom * that.numer
    )

  //进行方法重载
  def +(i: Int): Rational =
    new Rational(numer + i * denom,denom)

  def *(i: Int): Rational =
    new Rational(numer * i,denom)

  def -(i: Int): Rational =
    new Rational(numer - i * denom,denom)

  def /(i: Int): Rational =
    new Rational(numer,denom * i)

  //进行隐式转换 implicit
  //正如本章所示，使用运算符名称和方法创建方法定义隐式转换可以帮助您为哪个客户端设计库代码简洁易懂。
  //Scala为您提供了强大的力量设计这样易于使用的库，但请记住，有电源有责任。如果使用不当，
  //运算符方法和隐式转换都可以产生难以阅读和理解的客户端代码。 因为隐式转换是由编译器隐式应用的，
  //而不是在源代码中明确写下来的，所以对于客户端程序员来说这是不明显的正在应用什么隐式转换。
  //虽然运算符方法通常会使客户端代码更简洁，但它们只会使它更多客户端程序员能够识别并记住每个操作符的含义。
  //在设计库时，您应该牢记的目标不仅仅是实现简洁的客户端代码，但可读，可理解的客户端代码。
  //简洁性通常是可读性的重要组成部分，但是你可以把它简洁得过分。 通过设计图书馆，
  //使其具有高雅的简洁性同时可理解的客户端代码，您可以帮助那些客户端程序员高效地工作
  implicit def intToRational(x: Int) = new Rational(x)
}
