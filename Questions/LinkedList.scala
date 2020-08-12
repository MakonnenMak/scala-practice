object runner extends App {

  // Generic Single Linked List Data Type

  sealed trait LinkedList[A] {
    def length: Int = {
      this match {
        case End()      => 0;
        case Pair(h, t) => 1 + t.length
      }
    }

    def contains(someVal: A): Boolean = {
      this match {
        case End() => false;
        case Pair(h, t) =>
          if (someVal == h) return true else t.contains(someVal)
      }
    }

    def apply(index: Int): A = { //needs case for out of bounds
      this match {
        case Pair(h, t) =>
          if (index == 0)
            return h
          else
            t(index - 1)
        case End() => throw new Exception("End of List")
      }
    }
  };

  final case class End[A]() extends LinkedList[A];
  final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A];

  val myIntLL = Pair(1, Pair(2, Pair(3, End())));
  val myStringLL = Pair("First", Pair("Second", Pair("Third", End())));

}
