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

  // Adding All of the things
  def addOptions(A: Option[Int], B: Option[Int], C: Option[Int]): Option[Int] =
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
  // Division exercise

}
