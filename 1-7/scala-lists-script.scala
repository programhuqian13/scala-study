//对于共享相同类型的不可变对象序列，可以使用Scala的List类
//作为一个array，一个list[String]包含为String类型，scala中的list和java中的list不一样
//scala中的list是不可变得
val oneTwoThree = List(1,2,3)  //相当于定义了一个List[Int]的list，里面的元素为Int类型
println(oneTwoThree + " this is a List")
//列表是不可变的，它们的行为有点像Java字符串:当您调用一个列表上的方法时，
//该方法的名称可能暗示该列表将发生变化，但它会创建并返回一个具有新值的新列表。
//例如，List有一个名为:::的方法用于列表连接
val list1 = List(1,2)
val list2 = List(3,4)
val list1AndList2 = list1 ::: list2
println("one list1" + list1 + " and two list2 " + list2)
println("used ::: 连接两个list：" + list1AndList2)

//也许您将在列表中使用的最常见的操作符是::，它发音为cons。cons将一个新元素放在现有列表的开头，并返回结果列表
val consBeforeList = List(2,3)
val consAfterList = 1 :: consBeforeList
println("consBeforeList : " + consBeforeList)
println("consAfterList : " + consAfterList)
//这里不需要使用new List，应为List.apply()被定义在scala.List 这个对象中，是一个工厂方法
//::是一个右操作数的方法
//您可能怀疑:: method的关联性存在一些问题，
//但它实际上是一个需要记住的简单规则：如果在运算符表示法中使用了一个方法，
//例如* b，则在左操作数上调用该方法，如 在a.*(b)中 - 方法名称以冒号结尾。
//如果方法名称以冒号结尾，则在右操作数上调用该方法。
//因此，在1 :: consBeforeList中，:: method被调用在consBeforeList上，传入1，就像这样：consBeforeList. :: (1)
//制定一个空的list是使用nil，一种是创建包含中有的list，用cons操作进行追加一个nil元素到最后
val nilList = 1 :: 2 :: 3 :: Nil
println("this is a nil append last:" + nilList)

//list的所有操作
val createNilList = List()
val createNilListT = Nil  //或者创建的时候直接赋值为Nil
println("创建一个空的list：" + createNilList)
//创建有内容的list
val hasContentList = List("tony","hello","shanghai")
println("默认有内容的list：" + hasContentList)
//创建的有内容的另一种方式,已这种后面必须要追加一个Nil
val hasContentList2 = "tony" :: "hello" :: "shanghai" :: Nil
println("创建有内容的list通过::" + hasContentList2)
//将两个list合并
val listOne = List("one","two")
val listTwo = List("three","four")
val listInner = listOne ::: listTwo
println("通过:::合并两个list：" + (listOne ::: listTwo))
println("合并后的listInner：" + listInner)
//取出list中相应下标的值，下标从0开始计算
println("取出listOne第二个元素：" + listOne(1))
println("使用count方法（返回元素中数组长度为4的元素下标+1）：" + listInner.count(liststr => liststr.length == 4))
//返回取出N个之后的数据
println("返回取出2个之后的list的元素：" + listInner.drop(2))
//显示list中list.length-n的元素，就是除去倒数n个元素的list
println("除去倒数n个元素的list:" + listInner.dropRight(2))
//检查一个元素在list中是否存在,返回false或者true
println("检查一个元素在list中是否存在:" + listInner.exists(liststr => liststr == "tony"))
//过滤相关的元素
println("过滤相关的元素:" + listInner.filter(liststr => liststr.length == 3))
//检查list中所有的元素的条件，这里已结束字符判断，返回false或者true
println("检查list中所有的元素的条件，所有元素以o结束:" + listInner.forall(liststr => liststr.endsWith("o")))
//打印所有的list中的元素
listInner.foreach(liststr => print(liststr + " "))
//打印所有的list中的元素的简写方式
listInner.foreach(print)
//返回list中的第一个元素
println("返回list中的第一个元素：" + listInner.head)
//返回list中元素，不包括最后一个元素
println("返回list中的所有元素，不包括最后一个：" + listInner.init)
//判断list是否为空
println("判断list是否为空：" + listInner.isEmpty)
//返回list中的最后一个元素
println("返回list中最后一个元素：" + listInner.last)
//返回list的长度
println("返回list的长度信息：" + listInner.length)
//将list中所有的元素的值后面追加一个字符
println("将list中所有的元素的值后面追加一个字符:" + listInner.map(liststr => liststr + "l"))
//将list中元素作为字符串返回，并与相关字符拼接
println("将list中元素作为字符串返回，并与相关字符拼接:" + listInner.mkString("."))
//list中移除相关的元素
println("listInner:" + listInner)
// val listRemove = listInner.remove(liststr => liststr.length == 4)
// println("list中移除相关的元素:" + listRemove)
//这里的remove会报错，在当前这个版本已经一处掉了，自从2.9.0之后，现在我们使用filterNot这个
println("list中移除相关的元素:" + listInner.filterNot(liststr => liststr.length == 4))
//将list中的元素进行翻转
println("将list中的元素进行翻转：" + listInner.reverse)
//将list中的元素进行排序，sort在我当前这个版本已经移除了，自从2.9.0之后，变为了sortWith
// val sortList = listInner.sort((str,t) => str.charAt(0).toLower < t.charAt(0).toLower)
// println("将list中的元素进行排序之后的list：" + sortList)
val sortList = listInner.sortWith((str,t) => str.charAt(0).toLower < t.charAt(0).toLower)
println("将list中的元素进行排序之后的list：" + sortList)
//显示list中的所有的元素，减去第一个
println("显示list中的所有的元素，减去第一个:" + listInner.tail)
