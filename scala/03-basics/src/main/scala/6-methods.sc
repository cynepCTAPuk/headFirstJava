val a = 1
//val add = (a: Int, b: Int) => a + b
val add: (Int, Int) => Int = (a, b) => a + b
add(1, 2)

def max(a: Int, b: Int): Int = if (b > a) b else a
max(1, 2)

def sumSqr1(a: Int, b: Int): Int = {
  def sqr(x: Int) = x * x

  if (a + b > 10) return -1
  sqr(a) + sqr(b)
}
sumSqr1(3, 4)
sumSqr1(8, 9)

def sumSqr2(a: Int, b: Int): Int = {
  def sqr(x: Int) = x * x

  if (a + b > 10) -1
  else sqr(a) + sqr(b)
}

sumSqr2(6, 7)
