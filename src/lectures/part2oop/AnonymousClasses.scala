package lectures.part2oop

object AnonymousClasses extends App{

  abstract class Animal{
    def eat:Unit
  }

//  anonymous class
  val funnyAnimal:Animal = new Animal {
    override def eat: Unit = println("ahahahahahahah")
  }

  println(funnyAnimal.getClass)
  //  prints AnonymousClasses$$anon$1

  /*
  what actually happens
  class AnonymousClasses$$anon$1 extends Animal {
    override def eat: Unit = println("ahahahahahahah")
  }

  val funnyAnimal = new AnonymousClasses$$anon$1
   */

  class Person(name:String){
    def sayHi() = println(s"Hi, my name is $name, How can I help?")
  }

  //anonymous classes work for abstract and non abstract classes
  val jim = new Person("jim"){
    override def sayHi() = println(s"Hi, my name is Jim, How can I be of service?")
  }

  jim.sayHi()
}
