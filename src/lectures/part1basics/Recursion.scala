package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {


  def strConcat(str:String, n:Int):String = {
    @tailrec
    def concatHelper(str2:String, strAcc:String, x:Int):String={
      if(x<=1) strAcc else concatHelper(str,strAcc+str, x-1 )
    }
    str + concatHelper(str,"",n)
  }
  var x = System.currentTimeMillis()
  strConcat("I",50000)
  println(System.currentTimeMillis() - x)

  @tailrec
  def concatenateTailRec(aString: String,n:Int, accumulator:String): String ={
    if(n<=0) accumulator else concatenateTailRec(aString,n-1,aString + accumulator)
  }
  println(concatenateTailRec("hello",5,""))


  def isPrime(n: Int):Boolean ={
    @tailrec
    def isPrimeTailRec(t:Int, isStillPrime:Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t<=1) true
      else isPrimeTailRec(t-1, n % t != 0 && isStillPrime)
    }
    isPrimeTailRec(n/2,true)
  }
  println(isPrime(2003))
  println(isPrime(603))

  def fibonacci(n:Int):Int={
    @tailrec
    def fiboTailRec(i:Int, last:Int, nextToLast:Int):Int = {
      if (i >= n)  last
      else fiboTailRec(i+1, last+nextToLast, last)
    }
    if(n <= 2) 1
    else fiboTailRec(2,1,1)
  }
  println(fibonacci(8))
}

