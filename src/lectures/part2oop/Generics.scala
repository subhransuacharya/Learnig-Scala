package lectures.part2oop

object Generics extends App{
  class MyList[A]{ // A denotes generic type
    //use the type A
  }

  //traits can also be type parametrized

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  class MyMap[Key, Value] {
  //also works
  }

  //generic method
  //objects cannot be type parameterized
  object MyList{
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfInt = MyList.empty[Int]


  //variance problem
  //if cat and dog extend Animal does List[Cat] and List[Dog] extend List[Animal?]
  class Animal
  class Dog extends Animal
  class Cat extends Animal


//  1.Yes, List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal:Animal = new Cat
  val listOfAnimal:CovariantList[Animal] = new CovariantList[Cat]
//  listOfAnimal.add(new Dog) ??? HARD QUESTION
//  Ans. We return a list of Animals whenever we add anything other than a Cat
  //   class MyList[+A]{
  //     def add[B >: A](element:B): MyList[B] = ???
  //   }
  //   A = Cat
  //   B = Dog = Animal
  //   B is the superset of A

//  2.No, INVARIANCE
  class InvariantList[A]
  val invariantList:InvariantList[Animal] = new InvariantList[Animal]
//  val invariantList:InvariantList[Animal] = new InvariantList[Cat] //not supported

//  3.Hell no! CONTRAVARIANCE
  class ContravariantList[-A]
  val covariantList:ContravariantList[Cat] = new ContravariantList[Animal] //doesn't make sense

  //makes sense
  class Trainer[-A]
  val trainer:Trainer[Cat] = new Trainer[Animal]


//Bounded Types
  //upper bounded
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)
  //Cage only accepts  something that is subtype of Animal or Animal itself

  class Car
//  val newCage = new Cage(new Car)//intellij doesnt show but this will cause compile error

  //lower bounded
  class Cage2[A <: Animal](animal: A)
  //Cage2 only accepts  something that is supertype of Animal or Animal itself




















}
