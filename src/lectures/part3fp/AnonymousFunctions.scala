package lectures.part3fp

object AnonymousFunctions extends App {

  //anonymous function (LAMBDA) -- ALL 4 ARE SAME
  //  val doubler = (x:Int) => x * 2
  //  val doubler: Int => Int = (x: Int) => x * 2
  //  val doubler:Int => Int =  x => x * 2
  val doubler = (x: Int) => x * 2

  println(doubler(2))

  //multiple params in LAMBDA
  val adder: (Int, Int) => Int = (x: Int, y: Int) => x + y //multiple parameters have to be put in ()
  //  val adder = (x:Int, y:Int) => x+y

  //no parameters in LAMBDA
  val justDoSomething: () => Int = () => 3
  //  val justDoSomething = () => 3

  println(justDoSomething) // function object itself
  println(justDoSomething()) // call to the function

  //  curly braces with lambdas -- used sometimes
  val stringToInt = { (str: String) =>
    str.toInt
  }

  //more syntactic sugar

  //_ represents the parameter
  //  val niceIncrementer: Int => Int = (x:Int) => x + 1
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
  //  val niceAdder: (Int,Int) => Int = (a,b) => a + b
  val niceAdder: (Int, Int) => Int = _ + _ //equivalent to (a,b) => a + b

  /*
  1.  MyList: replace all FunctionX calls with lambdas
  2.  Rewrite the "special" adder as an anonymous function
 */


  //how curried functions are used in lambda
  val superAdder = new Function[Int, Function1[Int, Int]] {
    override def apply(v1: Int): Function1[Int, Int] = new Function[Int, Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }
  //can be written as below
  val superAdder2 = (x: Int) => (y: Int) => x + y
  //superadd == superadd2


}
