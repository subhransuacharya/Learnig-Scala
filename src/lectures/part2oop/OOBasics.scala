package lectures.part2oop

object OOBasics extends App {

  val person = new Person("John",26)
  println(person)
  println(person.age)
  println(person.x)
  person.greet("Daniel")
  person.greet()
}
//class parameters are not class fields and cannot be accessed using '.'
//to make it a class field add val or var before it
//constructor
class Person(name:String, val age: Int = 0) {
  //body can contain expressions or declarations or definitions or functions
  //all code of this block is executed during creation of the object

  val x = 2
  println(1+3)

  //method
  def greet(name:String) : Unit = println(s"${this.name} says: Hi, $name")

  //method overloading
  def greet():Unit = println(s"hi i am $name also ${this.name}")

  //constructor overloading
  def this(name:String) = this(name,0)

  def this() = this("John Doe")
}
//value of this code block is ignored as block expression
