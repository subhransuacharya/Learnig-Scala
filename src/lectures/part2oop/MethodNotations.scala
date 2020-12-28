package lectures.part2oop

object MethodNotations extends App{

  class Person(val name:String,favouriteMovie:String){
    def likes(movie:String): Boolean = {
      movie == favouriteMovie
    }
    def hangoutwith(person: Person): String = s"${this.name} is hangingig out with ${person.name}"
    def +(person: Person): String = s"${this.name} and ${person.name} are together."
    def unary_! : String = s"$name,what the heck?!"
    def isAlive : Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception")) //1

  //  called Infix Notaion or Operator Notation(works with methods with 1 parameter)
  println(mary likes "Inception") //equivalent to 1
  //infix notation = operator notaion(syntactic sugar) the style of calling infix functions

  //"operators" in scala
  val tom = new Person("Tom","FightClub")
  println(mary.hangoutwith(tom))
  println(mary hangoutwith tom) // here hangout with acts as an operator and results in a value

  //scala allows most of the symbols to be used as method names //ex akka actors have ! and ?
  println(mary.+(tom))
  println(mary + tom) //both are same

  println(1 + 2)
  println(1.+(2))//same
  //ALL OPERATORS ARE METHODS IN SCALA

  //prefix notation
  val x = -1 //equivalent with 1.unary_-
  val y =  1.unary_-
  //works with - + ~ !
  println(!mary)
  println(mary.unary_!)

  //postfix notation
  println(mary.isAlive)//often used in practice as it is easier to read
  println(mary isAlive)

  //apply
  println(mary.apply())
  println(mary()) //equivalent
}
