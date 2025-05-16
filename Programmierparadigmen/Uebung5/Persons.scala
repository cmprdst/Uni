package Uebung5

import java.time.LocalDate
import java.time.Period

class Person(
              val firstname: String,
              val lastname: String,
              val dayOfBirth: LocalDate
            ) {
  override def toString: String = {
    firstname + " " + lastname
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    val persons = List(
      new Person("Kerstin", "Herz", LocalDate.of(1995, 5, 31)),
      new Person("Matthias", "Zimmermann", LocalDate.of(1950, 1, 23)),
      new Person("Jana", "Schultheiss", LocalDate.of(1973, 10, 10)),
      new Person("Jennifer", "Fischer", LocalDate.of(1944, 12, 4)),
      new Person("Andreas", "Kaufmann", LocalDate.of(1964, 4, 3))
    )
    val surnameList = persons.map(persons => persons.lastname)
    val october = persons.filter(persons => persons.dayOfBirth.getMonthValue == 9)
    val ages = persons.map { person =>
      val period = Period.between(person.dayOfBirth, LocalDate.now())
      period.getYears
    }
    var averageAge = ages.sum.toDouble / persons.size
  }
}
