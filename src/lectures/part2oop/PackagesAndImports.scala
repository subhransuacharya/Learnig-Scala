package lectures.part2oop
import exercises.Writer

object PackagesAndImports extends App {
  // package members are accessible by their simple name
  val writer = new Writer("Daniel", "RockTheJVM", 2018)

  // import the package
  val playJ = new playground.JavaPlayground  // playground.JavaPlayground = fully qualified name

  // packages are in hierarchy
  // matching folder structure.

  // package object
  sayHello
  println(SPEED_OF_LIGHT)

}
