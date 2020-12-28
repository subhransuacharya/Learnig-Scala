package lectures.part2oop

object Objects extends App {
  //SCALA DOESNOT HAVE CLASS LEVEL FUNCTIONALITY("STATIC" IN JAVA)
  object Person{ //type + its only instance
//    "static/class" level functionality
    val N_EYES = 2
    var age = 2
    def canFly = false

    //CALLED FACTORY METHOD ----used to build person
    def apply(mother:Person, father:Person):Person = new Person("bobby")
  }
  class Person(val name:String){
//    instance level functionality
  }
//  COMPANIONS

  println(Person.N_EYES)
  println(Person.canFly)
  println(Person.age)

  //SCALA OBJECT = SINGLETON INSTANCE
  val mary = Person
  val john = Person
  println(mary==john)//point to same object

  val adam = new Person("mary")
  val eve =  new Person("eve")
  println(adam==eve)//2 separate instances thus false

  //factory method
  val bobby = Person.apply(adam, eve)
  println(bobby.name)



  //Scala application = scala object
//  with def main(args:Array[String]): Unit

  //to use this remove App
//  def main(args:Array[String]): Unit = {
//  //code
//  }

}
