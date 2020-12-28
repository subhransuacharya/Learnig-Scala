package lectures.part1basics

object StringOps extends App{

  var str : String = "Hello, I am learning Scala"
  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ","-"))

  val aNumberString = "2"
  val aNumber = aNumberString.toInt

  //prepending and appending - scala specific
  println('a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2))

  //S-interpolator
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old"
  val greeting2 = s"Hello, my name is $name and I will be turning ${age + 1} years old"
  println(greeting)
  println(greeting2)

  //f-interpolators
  //for formatted string similar to printf
  val speed  = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  println(myth)

  //can check for correctness
  val x = 1.1f
//  val str3 = f"$x%3d"//compile error Format specifier %3d cannot be used for an argument x (Float)

  //raw interpolator
  //prints everything literally
  println(raw"this is a \n new line")
  val escaped = "this is a \n new line"
  println(escaped) // in this case newline is escaped
}
