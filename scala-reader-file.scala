import scala.io.Source

if(args.length > 0){
  for(line <- Source.fromFile(args(0)).getLines())
    println(line.length + " " + line)
}
else
  Console.err.println("Please Enter file")
val lines = Source.fromFile(args(0)).getLines().toList
println("use function mode show file lines:" + lines)

def widthOfLength(str: String) = str.length.toString.length
var maxWidth = 0
for(line <- lines)
  maxWidth = maxWidth.max(widthOfLength(line))
  println("max width about line:" + maxWidth)
// after code sample result
val longStr = lines.reduceLeft(
  (a,b) => if(a.length > b.length) a else b
)
maxWidth = widthOfLength(longStr)
println("use reduceLeft method:" + maxWidth)
for(line <- lines){
  val numSpace = maxWidth -widthOfLength(line)
  var padding = " " * numSpace
  println(padding + line.length + " | " + line)
}
