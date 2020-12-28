package lectures.part2oop

object Inheritance extends App {

  //single class inheritance
//final class Animal(){
//sealed class Animal(){
  class Animal(){
   val creatureType:String = "wild"
//    final val creatureType:String = "wild"
//    sealed val creatureType:String = "wild"
    def eat = println("nom nom nom")
//    final def eat = println("nom nom nom")
//    sealed def eat = println("nom nom nom")
    private def sleep = println("zzzzzz") //inaccessible from child classes
    protected def wake = println("yawn") // accessible from child classes
  }
  //override
  class Dog extends Animal{
    override val creatureType = "dometstic"
    override def eat: Unit = println("crunch crunch")
  }


  //polymorphism
  val unknownAnimal:Animal = new SpecialDog("K9")
  unknownAnimal.eat


  val ed = new Dog
  ed.eat
  println(ed.creatureType)

  //overriding vals and vars in class signature
  class SpecialDog(override val creatureType:String) extends Animal{
    override def eat: Unit = println("crunch crunch")
  }
  val policeDog = new SpecialDog("trained")
  policeDog.eat
  println(policeDog.creatureType)

  //overriding vals and vars inside class
  class SpecialDog2(val dogType:String) extends Animal{
    override val creatureType:String = dogType
    override def eat: Unit = println("crunch crunch")
  }
  val assistantDog = new SpecialDog2("support")
  assistantDog.eat
  println(assistantDog.creatureType)


  class Cat extends Animal {
    def rise:Unit = {
      println("waking up.")
      wake
    }
  }

  val tom = new Cat
  tom.eat
//  tom.sleep //inaccessible
//  tom.wake //inaccessible
  tom.rise

//constructors
  class Person(name:String, age:Int) {
    def this(name:String) = this(name,0)
  }
//  class Adult(name:String, age:Int, id:String) extends Person(name,age) // in case there is no constructor overloading
  class Adult(name:String, age:Int, id:String) extends Person(name)



}
