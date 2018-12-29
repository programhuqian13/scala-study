object FallWinterSpringSummer extends App {
  for(season <- List("fall","Winter","Spring"))
    println(season + " : " + calculate(season))
}
