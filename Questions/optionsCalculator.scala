object Runner extends App {

  def readInt(str: String): Option[Int] =
    if (str matches "-?\\d+") Some(str.toInt) else None
  def calculator(operand1: String, operator: String, operand2: String): Unit =
    readInt(operand1) match {
      case None => println("Operand 1 isn't an Integer")
      case Some(o1) =>
        readInt(operand2) match {
          case None => println("Operand 2 isn't an Integer")
          case Some(o2) =>
            operator match {
              case "+" => println(o1 + o2)
              case "-" => println(o1 - o2)
              case _   => println("operator not defined yet")
            }
        }

    }

  calculator("5", "+", "5")
  calculator("10", "-", "2")

}
