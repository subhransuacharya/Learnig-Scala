package lectures.part2oop

object Exceptions extends App {
  val x: String = null
  //  println(x.length)
  //  this will throw a Null Pointer Exception

  //  1. throwing exceptions
  //  var aWeirdValue:String = throw new NullPointerException //returns "Nothing" but anything can hold Nothing even a String

  //  throwable classes extend the Throwable class
  //  Exceptions and errors are major subtypes
  //  Exceptions - something wrong with the program
  //  Error - something went wrong with the system ex stackOverflow

  //  2. catching exceptions
  def getInt(withExcepetions: Boolean): Int = {
    if (withExcepetions) throw new RuntimeException("No int for you")
    else 42
  }

  val potentialFail = try {
    //code that might fail
    getInt(true)
  } catch {
    //  influences the return type of this expression
    //    case e: RuntimeException => println("Caught Runtime Exception")
    case e: RuntimeException => 43 // if this is se
  } finally {
    //optional
    //does not influence the return
    //use only for side effects
    println("will get executed no matter what")
  }

  println(potentialFail)

  //3 how to define your own exceptions
  class MyException extends Exception

  //  val t = throw new MyException


  /*
    1.  Crash your program with an OutOfMemoryError
    2.  Crash with SOError
    3.  PocketCalculator
        - add(x,y)
        - subtract(x,y)
        - multiply(x,y)
        - divide(x,y)
        Throw
          - OverflowException if add(x,y) exceeds Int.MAX_VALUE
          - UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
          - MathCalculationException for division by 0
   */
  //  OOM Error
  //  var xArray = Array.ofDim(Int.MaxValue)//causes out of memory


  //  Stack overflow Error  SO
  def infinite: Int = 1 + infinite

//  val xinf = infinite


  class OverflowException extends RuntimeException

  class UnderflowException extends RuntimeException

  class MathCalculationException extends RuntimeException("Disvision By 0")

  object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int): Int = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int): Int = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int): Int = {
      if (y==0) throw new MathCalculationException
      x / y
    }

  }
//  println(PocketCalculator.add(Int.MaxValue,10))
  println(PocketCalculator.divide(2,0))

}
