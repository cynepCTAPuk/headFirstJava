(x: Int) => x * x
(x: Int, y: Int) => x + y

res0(2)
res1(2, 3)

val sqr = (x: Int) => x * x
val add = (x: Int, y: Int) => x + y

sqr(2)
add(2, 3)

sqr.isInstanceOf[Any]
sqr.isInstanceOf[AnyRef]

val sqr1 = new Function1[Int, Int] {
  override def apply(v1: Int): Int = v1 * v1
}
sqr1(3)

val add1 = new Function2[Int, Int, Int] {
  override def apply(v1: Int, v2: Int): Int = v1 + v2
}
add1(5, 7)

val sqr2: Int => Int = x => x * x
val add2: (Int, Int) => Int = (x, y) => x + y
add2(3, 6)

val add3: (Int, Int) => Int = _ + _
add3(7, 1)

val add4 = (_: Int) + (_: Int)
add4(5, 2)

val factorial: Int => Int = n =>
  if (n == 0) 1 else n * factorial(n - 1)
factorial(5)

val addSqr = (x: Int, y: Int) => {
  add(sqr(x), sqr(y))
}
addSqr(3, 4)

val addSqr1 = (x: Int, y: Int) => {
  val x2 = sqr(x)
  val y2 = sqr(y)
  add(x2, y2)
}
addSqr1(3, 4)

val addSqr2 = (x: Int, y: Int) => {
  val f = (a: Int) => a * a * a
  add(f(x), f(y))
}
addSqr2(3, 4)

val addSqr3: (Int, Int) => Int = { (x, y) =>
  val f = (a: Int) => a * a * a
  add(f(x), f(y))
}
addSqr3(3, 4)