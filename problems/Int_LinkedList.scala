object runner extends App {

  // Folds and generics
  sealed trait LinkedList {
    def fold(end: Int, f: (Int, Int) => Int): Int =
      this match {
        case End()      => end
        case Pair(h, t) => f(h, t.fold(end, f))
      }

    def length: Int =
      fold(0, (_, t) => 1 + t)
    def product: Int =
      fold(1, (h, t) => h * t)
    def sum: Int =
      fold(0, (h, t) => h + t)
  }

  final case class End() extends LinkedList;
  final case class Pair(head: Int, tail: LinkedList) extends LinkedList;

  val myIntLL = Pair(1, Pair(2, Pair(3, End())));
  println(myIntLL.length)

}
