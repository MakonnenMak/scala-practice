object Runner extends App {

  sealed trait LinkedList[A] {
    def map[B](fn: (A) => B): LinkedList[B] =
      this match {
        case Pair(hd, tl) => Pair(fn(hd), tl.map(fn))
        case End()        => End[B]()
      }

  }
  case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]
  case class End[A]() extends LinkedList[A]
  // 5.5.4.1 Mapping Lists
  // Double all elements, add 1 to them, then divide by 3
  val myllist: LinkedList[Int] = Pair(1, Pair(2, Pair(3, End())))
  // Implementing what Map does
  val mappedList: LinkedList[Double] =
    myllist.map[Double]((x) => (((x * 2) + 1) / 3))

  // 5.5.4.2 Mapping Maybe
  sealed trait Maybe[A] {
    def flatMap[B](fn: A => Maybe[B]): Maybe[B] =
      this match {
        case Full(v) => fn(v)
        case Empty() => Empty[B]()
      }
    def map[B](fn: A => B): Maybe[B] =
      this match {
        case Full(v) => Full(fn(v))
        case Empty() => Empty[B]()
      }
  }
  final case class Full[A](data: A) extends Maybe[A]
  final case class Empty[A]() extends Maybe[A]

  // 5.5.4.3 Sequencing Computations
  // Return a List[Int] containing both all the elements and their negation
  val list1 = List(1, 2, 3)
  println(list1.flatMap((x) => List(x, -1 * x)))
  val list2: List[Maybe[Int]] = List(Full(3), Full(2), Full(1))
  // Return a List[Maybe[Int]] containing even elements
  println(
    list2.map(maybe =>
      maybe.flatMap[Int](x => if (x % 2 == 0) Full(x) else Empty())
    )
  )

}
