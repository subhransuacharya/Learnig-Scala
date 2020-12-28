package lectures.part2oop

object CaseClasses extends App {
  /*
  equals, hashcode, toString
   */

  case class Person(name: String, age:Int) {
    // class parameters are promoted to fields


  }

  val jim:Person = new Person("jim",2)
  println(jim.name)


  //sensible tostring
  println(jim.toString) // == println(jim)


  // equals and hashcode implemented out of box
  val jim2 = new Person("jim",2)

  println(jim==jim2) //true in case of case classes ....not true in case of regular class


  //CCs have handy copy methods
  val jim3 = jim.copy()
  val jim4 = jim.copy(age = 54)


//  case classes have companion object
  val person = Person
  val mary = Person("Mary", 23) // calls apply method of Person ///apply method of case class calls the constructor


  //case classes are serializable
  //akka spark

  //case classes have exractor pattern and can be used in pattern matching


  case object UnitedKingdom{ /// case object  dont have companion objects because they are companion objects
    def name = println("the")
  }

}
