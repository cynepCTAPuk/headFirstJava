object Main {
def main(args: Array[String]) {

  import Naval.{Point, Field, Ship, Fleet, Game}
  import Lesson.field

  def validateShip(ship: Ship): Boolean = ??? // определить, подходит ли корабль по своим характеристикам
  def validatePosition(ship: Ship, field: Field): Boolean = ??? // определить, можно ли его поставить
  def enrichFleet(fleet: Fleet, name: String, ship: Ship): Fleet = ??? // добавить корабль во флот
  def markUsedCells(field: Field, ship: Ship): Field = ??? // пометить клетки, которые занимает добавляемый корабль

  def tryAddShip(game: Game, name: String, ship: Ship): Game = ??? // логика вызовов методов выше
}}