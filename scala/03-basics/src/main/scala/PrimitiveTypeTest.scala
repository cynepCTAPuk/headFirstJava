class PrimitiveTypeTest {
  def max(v1: Int, v2: Int) = if (v1 > v2) v1 else v2

  def f(v: Any) = println(v)

  max(1, 3)
  f(1)
  f(1.234)

}
