object Main241 extends App {
  def greeting(name: String): Unit = {
    println(prefix + name)
  }
  val prefix = "Hello "
  val name = "Oleg"
  greeting(name)
}
