object runner extends App {
  // Adding Things
  def addOptions(A: Option[Int], B: Option[Int]): Option[Int] =
    for {
      a <- A
      b <- B
    } yield a + b
  // Flat Map version
  def addOptions2(A: Option[Int], B: Option[Int]): Option[Int] =
    A.flatMap { a =>
      B.map { b => (a + b) }
    }

  def addOptions(A: Option[Int], B: Option[Int], C: Option[Int]) =
    for {
      a <- A
      b <- B
      c <- C
    } yield a + b + c

  // Fold version
  def addOptions2(A: Option[Int], B: Option[Int], C: Option[Int]): Option[Int] =
    A.flatMap { a =>
      (
        B.flatMap { b =>
          (
            C.map { c =>
              a + b + c
            }
          )
        }
      )
    }

  def notZero(someNum: Int) = if (someNum != 0) Option(someNum) else None
  // Division exercise
  def divide(num: Option[Int], denom: Option[Int]): Option[Int] =
    for {
      n <- num
      d <- denom
    } yield n / d

  println(divide(Option(4), notZero(0)))

}
