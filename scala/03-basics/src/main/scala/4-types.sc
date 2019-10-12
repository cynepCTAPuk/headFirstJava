import java.time.{DayOfWeek, LocalDateTime}

1.isInstanceOf[Any]
"".isInstanceOf[Any]

class MyClass
val c = new MyClass
c.isInstanceOf[Any]

val v1: Char = 'a'
val v2: Double = v1

c.isInstanceOf[AnyRef]
"Hello".isInstanceOf[AnyRef]
"Hello".getClass

val v0: String = null
val v2: AnyRef = null
val v3: MyClass = null
//val v4: AnyVal  = null

def error(message: String): Nothing =
  throw new IllegalStateException(message)
def dayOfWeek: DayOfWeek = {
  val d = LocalDateTime.now().getDayOfWeek
  if(d!=DayOfWeek.MONDAY) d
  else error("Сегодня Понедельник")
}
def dayOfWeekNum: Int = {
  val d = LocalDateTime.now().getDayOfWeek
  if(d!=DayOfWeek.MONDAY) d.getValue
  else error("Сегодня Понедельник")
}
println(dayOfWeek)
println(dayOfWeekNum)

def f(a1: Int, a2: String): String = ???
//f(10,"ten")
def infiniteLoop(): Nothing = infiniteLoop()