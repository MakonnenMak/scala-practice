object runner extends App {
  val people = Set("Alice", "Bob", "Charlie", "Derek", "Edith", "Fred")
  val ages = Map(
    "Alice" -> 20,
    "Bob" -> 30,
    "Charlie" -> 50,
    "Derek" -> 40,
    "Edith" -> 10,
    "Fred" -> 60
  )
  val favoriteColors =
    Map("Bob" -> "green", "Derek" -> "magenta", "Fred" -> "yellow")
  val favoriteLolcats =
    Map("Alice" -> "LongCat", "Charlie" -> "CeilingCat", "Edith" -> "CloudCat")

  // Write a method favorite color
  // Input name:String
  // Output color:String
  def favColor(name: String): String =
    return favoriteColors(name)
  // Update favorite color to add
  // default 'biege' if they don't have one
  def favColor2(name: String): String =
    return favoriteColors.getOrElse(name, "biege")
  // Write method print colors that prints
  // everyones favorite color
  def printAllColors(colors: Map[String, String]): Unit =
    colors.map(pair => println(pair._2))
  // Write a method lookup that accepts a name
  // and one of the maps and returns relevant
  // value from the map. Ensure return type
  // of the method matches value type of the map
  def getValues[A](name: String, values: Map[String, A]): Option[A] =
    values.get(name)
  // Calculate color of the oldest person
  // TODO improve types, use options incase maps are empty
  val oldest: String =
    ages
      .foldLeft(("na", Int.MinValue))((oldest, nextPerson) =>
        if (oldest._2 > nextPerson._2) oldest else nextPerson
      )
      ._1

  val favorite: String =
    favoriteColors(oldest)

  println(favorite)
}
