package exercises

object MethodNotations extends App {
  class Person(val name:String,favouriteMovie:String, val age:Int = 0){
    def likes(movie:String): Boolean = {
      movie == favouriteMovie
    }
    def hangoutwith(person: Person): String = s"${this.name} is hangingig out with ${person.name}"
    def +(person: Person): String = s"${this.name} and ${person.name} are together."
    def +(nickName: String) = new Person(s"$name ($nickName)",favouriteMovie)
    def unary_+ :Person= new Person(name, favouriteMovie, age+1)
    def unary_! : String = s"$name,what the heck?!"
    def isAlive : Boolean = true
    def learns(subject:String) = s"$name is learning $subject"
    def learnsScala() = learns("Scala")

    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"
    def apply(n:Int): String = s"$name watched $favouriteMovie $n times."
  }
  val mary = new Person("Mary", "Inception")
//exercises
  //1(infix) overload + to set a new nickname
  println((mary + "the rockstar")())
  println((mary + "the rockstar").apply())

  //2(prefix) add age to person and add unary + which increments age and returns new person with age as age + 1 ex. +mary
  println((+mary).age)

  //3 add learns method in Person => mary learns scala
  //  add a learnsScala method which calls learn with scala argument
  //  use it in postfix notation
  println(mary.learnsScala())
  println(mary.learns("Scala"))

  //4  overload apply method
  //  mary.apply(2) => mary watched inception 2 times
  println(mary.apply(2))
  println(mary(2))

}
