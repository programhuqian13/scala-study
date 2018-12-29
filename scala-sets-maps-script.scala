//因为Scala旨在帮助您利用功能和命令式样式，所以它的集合库可以区分它们可变和不可变的集合。
//例如，数组总是可变的; 列表总是不可变的。 Scala还提供可变和不可变的集合和映射的替代方案，
//但对两个版本使用相同的简单名称。 对于集合和映射，Scala在类层次结构中建模可变性
//Scala API包含一个用于集合的基本特征，其中的特征类似于Java接口
// var set1 = Set("tony","hello")
// set1 += "world"  //这个添加是在后面添加
//查询set中是否包含hello字符串
// println(set1.contains("hello"))
// println("添加元素之后的set集合：" +set1)
//set在scala中有两种实现，一种是可变的，一种是不可变得。当使用+方法进行操作的时候，不可变和可变的表现形式不一样
//不可变得会将元素加到原来你的set集合中，并且返回一个新的set集合，但是可变的会加到以前的set集合中，不会返回一个新的set集合
//因此可变的可以使用+=的操作，但是不可变的不能使用+=操作
//这里默认为可变的
//如果不是可变的话，可以import导入相关的实现
import scala.collection.mutable.Set
//导入不可变得HashSet
import scala.collection.immutable.HashSet
//导入可变的map包
import scala.collection.mutable.Map
var muSets = Set("hello","scala")
muSets += "good"  //也可以写成muSets.+=("good")  这个实在前面添加？ why？
println("可变的set使用：" + muSets)

val hashSet = HashSet("helloHashSet","world")
println("不可变得hashSet：" + hashSet + "error?")
//map的使用，scala也提供了两个map的实现。一个是可变的，一个是不可变得map
val map1 = Map[Int,String]()
map1 += (1 -> "this is a first")
map1 += (2 -> "this is a secord")
map1 += (3 -> "this is a three")
println("打印map中的map(1):" + map1(1))
//当我们给map添加元素的时候，如上使用+=操作符以及->
//Scala编译器转换二元运算表达式，如1 - >“Go to island”成(1).->("Go to island")。 因此，当你说1 ->“Go to island”时，
//你实际上是在一个值为1的整数上调用一个名为 ->的方法，传入一个值为“Go to island”的字符串。
//这个 ->方法，其中您可以调用Scala程序中的任何对象，返回一个双元素元组包含键和值。然后，您将此元组传递给+=方法
