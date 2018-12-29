//Scala为其基本类型提供了丰富的运算符。这些运算符实际上只是普通的一个很好的语法方法调用。
//例如，1 + 2实际上与（1）.+（2）。换句话说，类Int包含一个名为+的方法，它接受一个I​​nt和返回Int结果
val sum = 1+2
println("1 + 2:" + sum)
val sumMethod = (1).+(2)
println("(1).+(2):" + sumMethod)
//实际上，Int包含几个带有不同的重载+方法参数类型。
//例如，Int有另一个方法，也叫做+接受并返回一个Long。 如果将一个Long添加到Int，则使用此重载+方法将被调用
val suml = 1 + 2L
println("sum Long:" + suml)
//+符号是一个运算符 - 一个特定的中缀运算符。 操作者符号不仅限于类似+的方法，看起来像其他的操作符语言。
//您可以在运算符表示法中使用任何方法。 例如，class String有一个方法indexOf，它接受一个Char参数。
//该indexOf方法在字符串中搜索指定的第一个匹配项character，如果找不到该字符，则返回其索引或-1。 您可以
//使用indexOf作为运算符
val str = "Hello,world"
println("str value:" + str)
val strIndex = str indexOf 'o'
println("str indexof:" + strIndex)
//String提供了一个重载的indexOf方法两个参数，要搜索的字符和索引开始
val strIndexOrver = str indexOf ('o',5)
println("str indexof两个参数：" + strIndexOrver)
//在Scala中，运算符不是特殊的语言语法：任何方法都可以是一个操作。
//使方法成为操作符的方法就是如何使用它。当您编写s.indexOf('o')时，indexOf不是运算符。
//但当你写s indexOf 'o'时，indexOf是一个运算符，因为你在运算符表示法中使用它
//Scala还有另外两个运算符表示法：前缀和后缀。 在前缀表示法中，您放置方法.例如，在调用方法的对象之前的名称-7中的' - '。
//在后缀表示法中，您将该方法放在对象之后，用于例如，“7 toLong”中的“toLong”。
//与中缀运算符符号相反 - 运算符占两个操作数，一个在左边，另一个在右前缀和后缀操作符是一元的：它们只占用一个操作数。
//在前缀表示法中，操作数在操作员的右边。 前缀运算符的一些示例是-2.0，！found，和~0xFF。
//与中缀运算符一样，这​​些前缀运算符也是一种调用方法的简便方法。 但是，在这种情况下，名称该方法的“unary_”前置于操作符。
//例如，Scala将表达式-2.0转换为方法调用“（2.0）.unary_-”
val unaryBefore = -2.0
val unaryAfter = (2.0).unary_-
println("unaryBefore:" + unaryBefore)
println("unaryAfter:" + unaryAfter)
//唯一可用作前缀运算符的标识符是+， - ，！和〜。因此，如果您定义名为unary_！的方法，
//则可以调用该方法使用前缀运算符表示法在适当类型的值或变量上，比如!p。
//但是如果你定义一个名为unary_ *的方法，你将无法做到使用前缀运算符表示法，因为*不是四个标识符之一可以用作前缀运算符。
//您可以正常调用该方法，如在p.unary_ *中，但是如果你试图通过*p调用它，Scala会将其解析为如果你写了*.p，这可能不是你的想法!4
//Postfix运算符是在没有点或括号的情况下调用它们时不带参数的方法。
//在Scala中，您可以在方法调用上留下空括号。 惯例是你包括圆括号方法有副作用，例如println()，但是你可以将它们关闭该方法没有副作用
val strtest = "Hello,World"
println("strtest:" + strtest)
println("strtest.toLowerCase:" + strtest.toLowerCase)
println("strtest toLowerCase:" + strtest toLowerCase)
//如果你真的想要IEEE 754的余数，你可以调用scala.math上的IEEEremainder
println("math.IEEEremainder:" + math.IEEEremainder(11.0,4.0))
// 数字类型还提供一元前缀运算符+（方法unary_ +）和 - （方法unary_-），
//它们允许您指示正数或负数，如-3或+4.0。 如果未指定一元+或 - ，则将文字数字解释为正数。
//一元+仅存在与一元对称的对称 - 但没有效果。 一元 - 也可用于否定变量
val neg = 1 + -3
println("neg = 1 + -3:" + neg)
val y = +3
println("y=+3:" + y)
println("-neg:" + -neg)
//相关的比较操作符 > < >= <= = ，这个java中的一样，也和其他的语言一样
//||和&&操作符
val toTrue = true
val question = toTrue || !toTrue
println("question ||：" + question)
val paradox = toTrue && !toTrue
println("paradox &&：" + paradox)
//定义一个方法
def salt() = {println("salt"); false}
def pepper() = {println("pepper"); true}
println(salt())
println(pepper())
val result = salt() && pepper()
println("result:" + result)
//scala中的位运算
//按位和1（0001）和2（0010）中的每个位，产生0（0000），合并0/1变为0 1/1为1
println("1&2:" + (1 & 2))
//按位或操作（0001）和2（0010）中的每一位，产生3（0011） 合并 0/0 为0 0/1为1 1/1为1
println("1 | 2:" + (1 | 2))
//按位1（0001）和3（0011）中的每个位，产生2（0010）合并 0/0 为0 0/1为1 1/1为0
println("1^3:" + (1 ^ 3))
//反转1(0001)中的每一位，得到-2 变为1110
println("~1:" + (~1))
//scala中还提供了三个位移操作符 左移(<<)，右移(>>)，无符号右移(>>>)
//移位方法在中缀操作符表示法中使用时，将操作符左边的整数值移位为右边的整数值指定的值。
//左移和无符号右移移动时填充0。右移在左移时用左值的最高位(符号位)填充
//二进制中的-1是11111111111111111111111111111111
println("-1 >> 31:" + (-1 >> 31)) //-1被移位到右边的31位位置。 由于Int由32位组成，因此该操作有效地移动最左边的位直到它成为最右边的位。由于>>方法向右移动时填充1，因为-1的最左位是1，结果是 与原始左操作数相同，32位，或-1
println("-1 >>> 31:" + (-1 >>> 31)) //最左边的位再次向右移动直到它处于最右边的位置，但这次沿着路径填充零。 因此这次的结果是二进制00000000000000000000000000000001，或1.
println("1 << 2:" + (1 << 2)) //左操作数1，左移两个位置（用零填充），产生二进制00000000000000000000000000000100，或4
//scala中的对象比较 使用 == 或者 ！=
println("1==2:" + (1 == 2))
println("1 != 2:" + (1 != 2))
println("2==2:" + (2 == 2))
println("List(1,2,3) == List(1,2,3):" + (List(1,2,3) == List(1,2,3)))
println("List(1,2,3) == List('a','s','f'):" + (List(1,2,3) == List('a','s','f')))
println("List(1,2,3) == hello:" + (List(1,2,3) == "hello"))
println("1 == 1.0: " + (1 == 1.0))
println("List(1,2,3) == null:" + (List(1,2,3) == null))
println("null == List(1,2,3):" + (null == List(1,2,3)))
//==是经过精心设计的，以便您在大多数情况下得到您想要的相等比较。
//这是通过一个非常简单的规则实现的:首先检查左侧是否为null，如果不是null，则调用equals方法,因为equals是一种方法，所以您得到的精确比较取决于左边参数的类型。由于存在自动null检查，您不必亲自检查
//Scala ==与Java的不同之处在Java中，您可以使用==来比较原始类型和引用类型。 在原始类型上，Java's ==比较值相等，就像在Scala中一样。
//但是，在引用类型上，Java的==比较引用相等性，这意味着两个变量指向JVM堆上的同一个对象。
//Scala提供了一个用于比较引用相等性的工具，名称为eq。 但是，eq及其相反的ne仅适用于直接映射到Java对象的对象
