type Calc[T] = Map[String, T] => T
implicit def numericExpr[T: Numeric]: Expr[Calc[T]] = new Expr[Calc[T]] {
  import Numeric.Implicits._
  // implement all needed methods
}