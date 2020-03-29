final case class StringVect(str: String) extends AnyVal with Vect {
  type Item = Char
  def length                                 = str.length
  def get(index: Int)                        = str.charAt(index)
  def set(index: Int, item: Char): Aux[Char] = StringVect(str.updated(index, item))
}

final case class BoolVect64(values: Long) extends AnyVal with Vect {
  type Item = Boolean
  def length          = 64
  def get(index: Int) = ???
  def set(index: Int, item: Boolean): Aux[Boolean] = ???
}

final case class BoolVect8(values: Byte) extends AnyVal with Vect {
  type Item = Boolean
  def length          = 8
  def get(index: Int) = ???
  def set(index: Int, item: Boolean): Aux[Boolean] = ???
}

def toList(vect: Vect): List[vect.Item] = ???