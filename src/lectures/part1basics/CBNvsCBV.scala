package lectures.part1basics;

object CBNvsCBV extends App{
  def calledByValue(x:Long): Unit ={
    println("by value: "+x)
    println("by value: "+x)
  }
//  by value: 206694941741300
//  by value: 206694941741300

  def calledByName(x: =>Long): Unit ={
    println("by value: "+x)
    println("by value: "+x)
  }
//  by value: 206695021106700
//  by value: 206695021159000

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite():Int = 1 + infinite()

  def printPair(x:Int, y: => Int):Unit = println(x)

//  printPair(34, infinite()) // doesn't cause stack overflow
//  printPair(infinite(),34) //causes stack overflow

}
