object runner extends App {

  // Folds and generics
  sealed trait LinkedList {
    def fold(end: Int, f: (Int, Int) => Int): Int =
      this match {
        case End()        => end
        case Pair(hd, tl) => f(hd, tl.fold(end, f))
      }

    def length: Int =
      fold(0, (_, tl) => 1 + tl)
  }

  final case class End() extends LinkedList;
  final case class Pair(head: Int, tail: LinkedList) extends LinkedList;

  val myIntLL = Pair(1, Pair(2, Pair(3, End())));
  println(myIntLL.length)

}
