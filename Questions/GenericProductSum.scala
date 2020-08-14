object Runner extends App {
  //Generic Product Type -- extends to Tuple
  case class Pair[A, B](a: A, b: B)
  val pair = Pair[String, Int]("hi", 2)

  //Generic Sum Time
  sealed trait Sum[A, B]
  case class Left[A, B](value: A) extends Sum[A, B]
  case class Right[A, B](value: B) extends Sum[A, B]

  println(Left[Int, String](1).value)
}
