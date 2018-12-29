//定义一个数组，类型为字符串String的类型，长度为3
//对于数组而言，数组里面的元素必须为同一个类型
var greetStrings = new Array[String](3)
greetStrings(0) = "Hello "
greetStrings(1) = ", "
greetStrings(2) = "world"
for(i <- 0 to 2)
  print(greetStrings(i))
