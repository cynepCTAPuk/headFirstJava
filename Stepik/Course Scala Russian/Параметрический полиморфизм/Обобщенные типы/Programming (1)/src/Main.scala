case class Pair (first: T, second: T) {
  def smaller =
    if (first < second) first
    else second
}

val p = Pair(BigInt("1000000000000000"),BigInt("7000000000000000"))
require(p.smaller == BigInt("1000000000000000"))