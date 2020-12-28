package lectures.part1basics

import scala.annotation.tailrec

object Functions extends App{
  def aFunc(a: String, b: Int) :String = {
    a + " " + b  //expression
  }

  def bFunc(a: String, b: Int) :String =
    a + " " + b  //expression

  println(aFunc("hello", 3))

  def paramelterlessFunc() = {
    "2"
  }

  println(paramelterlessFunc())
  println(paramelterlessFunc) // there is a warning


  //concatenating same string n times
  def aRepeatedFunc(aString : String, n : Int) :String = {
    if (n==1) aString else aString + aRepeatedFunc(aString, n-1)
  }

  println(aRepeatedFunc("Hello", 3))

  def sideEffectEx(str:String):Unit = println(str)


  def aBigFunction(n:Int) :Int = {
    def aSmallerFunction(a:Int, b:Int): Int = a + b
    aSmallerFunction(n, n-1)
  }

  def greet(name:String, age:Int)= "Hi, I am " + name + " and I am " + age +" years old."
  println(greet("hari",7))

  def factorial(n:Int):Int= if (n<=1) 1 else n * factorial(n-1)

  println(factorial(3))


  def fib(n:Int):Int = {
    if(n<=2) 1 else fib(n-1) + fib(n-2)
  }

  println(fib(1))
  println(fib(2))
  println(fib(3))
  println(fib(4))

  def isPrime(n:Int):Boolean ={
    @tailrec
    def isPrimeUntil(t:Int):Boolean={
      if (t<=1) true else n%t!=0 && isPrimeUntil(t-1)
    }
    isPrimeUntil(n/2)
  }

  println(isPrime(20072))

}
