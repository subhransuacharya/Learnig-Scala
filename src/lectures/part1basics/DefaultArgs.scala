package lectures.part1basics

object DefaultArgs extends App {

  def trFact(n:Int, acc:Int):Int = {
    if(n<1) acc
    else trFact(n-1,n*acc)
  }

  var fact = trFact(10,1)
  //just because of the technicality, the accumulator had to be passed everytime

  def trFact2(n:Int, acc:Int = 1):Int = {
    if(n<1) acc
    else trFact(n-1,n*acc)
  }

  var fact2 = trFact2(10)
  val fact3 = trFact2(10,2)

  def savePic(format:String = "jpg", width: Int = 1920, height:Int = 1080):Unit = println("Saving picture")
  savePic("png")
  //lets say we only want to pass width
  //savePic(800) //throws error as compiler is only able to detect parameters in sequence and expects first one to be String

  /*
  * solution:
  * -pass in every leading argument
  * -name the arguments
  */
  //solution1
  savePic("jpg",800)


  //solution2
  savePic(format = "png", width = 1366, height = 720)// we can send all parameters
  savePic(width = 1366, height = 720, format = "png")// we can change sequence of parameters
  savePic(height = 720) // we can non initial parameters





}
