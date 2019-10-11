import scala.io.StdIn

object HelloApp extends App {
  val name = StdIn.readLine("Hi! Enter your name: ")
//  println("Hello " + name + "!")
    println(s"Hello $name!")
}
