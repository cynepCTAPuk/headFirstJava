case class Pair (first: T, second: S) {
    //...
}

val pair = Pair(123, "Oleg").swap
require(pair.first ==  "Oleg")
require(pair.second == 123)