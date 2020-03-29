implicit val stringOrderExpr: Expr[Print] = new Expr[Print] {
  override def literalInt(value: Int) = ???
  override def variable(name: String): Print = ???
  override def times(x: Print, y: Print): Print = ???
  override def plus(x: Print, y: Print): Print  = ???
  override def minus(x: Print, y: Print): Print = ???
  override def negate(x: Print): Print          = ???
}