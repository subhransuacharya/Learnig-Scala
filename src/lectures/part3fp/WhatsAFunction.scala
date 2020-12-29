package lectures.part3fp

object WhatsAFunction extends App {

  //DREAM: using functions as first class elements
  //problem oop
  class Action {
    def execute(a: Int): Int = ???
  }

  //scala solves this by using trait and apply
  trait MyFunction[A, B] {
    def apply(element: A): B = ???
  }

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  //doubler acts like a function
  println(doubler(2))

  //function types = function1, function2, .....function22
  //but function with 1 parameter with 1 result it is Function1[A, B]
  val stringToIntConverter = new Function[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }

  println(stringToIntConverter("3") + 4)


  val adder = new ((Int, Int) => Int) { //syntactic sugar for new Function2[Int,Int, Int]
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }
  println(adder(1, 2))


  //Function Types
  //Function2[A,B,R] === (A,B) => R

  //ALL SCALA FUNCTIONS ARE OBJECTS

  /*
  1. take 2 strings and concatenate them
  2. mylist - transform MyPredicate and MyTransformer into function types
  3. define a function which takes an Int and returns another function which takes an Int and returns an Int
      - what's the type of the function
      - how to do it
   */

  val joiner = new ((String, String) => String) {
    override def apply(v1: String, v2: String): String = v1 + v2
  }
  println(joiner("hello", "world"))

  //called a curried function
  val superAdder = new Function[Int, Function1[Int, Int]] {
    override def apply(v1: Int): Function1[Int, Int] = new Function[Int, Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }
  //syntactic sugar implementation
  val curriedFunction = new Function[Int, (Int) => Int] {
    override def apply(v1: Int): (Int) => Int = (v2: Int) => v1 + v2
  }

  val adder10 = superAdder(10)
  println(adder10(5))

  println(superAdder(3)(4))

}
