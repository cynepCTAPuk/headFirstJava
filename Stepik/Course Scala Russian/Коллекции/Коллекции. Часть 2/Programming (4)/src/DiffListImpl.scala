final class DiffListImpl[A](listFunc: List[A] => List[A]) extends DiffList[A](listFunc) {
  def prepend(s: List[A]) = ???

  def append(s: List[A]) = ???

  def result = ???
}