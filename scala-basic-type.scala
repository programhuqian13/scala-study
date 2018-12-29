//integer字面量
//integer字面量包含 byte，short，int，long和相关的进制类型
//如果数值已0x或者0X开头的，它作为16进制，0-9作为A-F申明
val hex = 0x5
val hex2 = 0x00FF
val hex3 = 0xcafebabe
println(hex)
println(hex2)
println(hex3)
//输出的时候都是以10进制输出的
//如果以一个0开始的，将作为8进制，并且只包含0-7
// val oct = 035
// val nov = 0777
// val dec = 0321
// println(oct)
// println(nov)
// println(dec)
//输出的时候都是以10进制输出的,从2.10的版本之后就取消了八进制
//如果开始没有0，和其他的修饰就为10进制
val dec1 = 31
val dec2 = 255
val dec3 = 20
println(dec1)
println(dec2)
println(dec3)
//如果字面量的后面结尾为L或者l，将作为Long类型，否则为Int类型
val prog = 0xCAFEBABEL
val tower = 35L
var of = 31l
println(prog)
println(tower)
println(of)
//如果是short和Byte类型的话，需要申明
val shortVal: Short = 367
val byteVal: Byte = 38
println(shortVal)
println(byteVal)
//浮点型字面量
//浮点型字面量由十进制数字组成，可选地包含小数点，可选地后跟E或E和指数,打印默认为double类型
val big = 1.234
val bigger = 1.2345e1
val biggerStill = 123E45
println(big)
println(bigger)
println(biggerStill)
//如果需要打印出来的为Float类型的话，需要在后面加上F或者f
val little = 1.2345F
val littleBigger = 3e5f
//也可以手动设置为Double类型
val antherDouble = 3e5
val yetAnther = 3e5D
println("float:" + little)
println("float:" + littleBigger)
println("double:" + antherDouble)
println("double:" + yetAnther)
//字符字面量
//字符字面量由单引号之间的任何Unicode字符组成
val a = 'A'
println("char:" + a)
// 除了在单引号之间提供明确的字符外，您还可以
//可以为前面的字符代码点提供八进制或十六进制数
//通过反斜杠。 八进制数必须介于'\ 0'和'\ 377'之间。 对于
//例如，字母A的Unicode字符代码点是101八进制
val c = '\101'
println("unicode：" + c)
val d = '\u0041'
println("char:" + d)
val f = '\u0044'
println("char:" + f)
val B\u0041\u0044 = 1
println("bad:" + B\u0041\u0044)
val backslash = '\\'
println("backslash:" + backslash)
//字符串是比较常用的类型，这个是需要使用双引号进行申明
val hello = "hello"
println("hello :" + hello)
val escapes = "\\\"\'"
println("escapes:" + escapes)
//进行字符串排版输出
println("""while wo asd  fa s sdf   asdf sasdf  sasdf
            asdaa asdas asd  heloow tkahsj fsjasda """)
//这上面是没有对齐的，我们可以使用stripMargin方法
println("""|while wo asd  fa s sdf   asdf sasdf  sasdf
           |asdaa asdas asd  heloow tkahsj fsjasda """.stripMargin)
//符号字面量
//符号文字写成'ident，其中ident可以是任何字母数字标识符。
//此类文字映射到预定义类scala.Symbol的实例。
//具体来说，文字'cymbal将由编译器扩展为工厂方法调用：Symbol（“cymbal”）。
//符号文字通常用于您只使用动态类型语言中的标识符的情况
val s = 'aSymbol
println("Symbol:" + s)
println("Symbol name:" + s.name)
//boolean 字面量,boolean 取值为true或者false
val bool = true
val bool2 = false
println(bool)
println(bool2)
