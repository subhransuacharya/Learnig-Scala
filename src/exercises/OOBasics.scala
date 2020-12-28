package exercises

object OOBasics extends App {
  //example 1
  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("great expectations", 1861, author)
  println(novel.authorAge())
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imposter))

  //example 2
  val counter = new Counter()
  counter.inc.print()
  counter.inc.inc.inc.print()
  counter.inc(10).print()
}

class Novel( name:String,  year:Int,  author:Writer){
  def authorAge()= year - author.year
  def isWrittenBy(author:Writer) = author == this.author
  def copy(newReleaseYear: Int) = new Novel(name, newReleaseYear, author)
}


class Writer(firstName:String, surname:String,val year:Int){
  def fullName()= this.firstName + " " + this.surname
}



class Counter(val count:Int=0){
  def currentCount():Int = this.count
  def inc:Counter = { println("incrementing.."); new Counter(count + 1) }
  def inc(n:Int):Counter = {if (n<=0) this else inc.inc(n-1)}
  def dec:Counter = { println("decrementing"); new Counter(count - 1) }
  def dec(n:Int):Counter = { if (n<=0) this else dec.dec(n-1) }
  def print()= println(count)
}