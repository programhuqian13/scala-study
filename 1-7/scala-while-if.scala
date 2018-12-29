/**
* scala遍历使用while和if条件判断语句
*/
var i= 0
while(i < args.length){
  println(args(i))
  i += 1
}

var j = 0
while(j < args.length){
  if(j != 0)
    print(" ")
  print(args(j))
  j += 1
}
println()
