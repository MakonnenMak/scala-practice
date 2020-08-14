object Runner extends App {
  // Convert Tree to String
  sealed trait Tree[A] {
    def fold[B](baseCase: A => B, f: (B, B) => B): B;
  }
  case class Node[A](left: Tree[A], right: Tree[A]) extends Tree[A] {
    def fold[B](baseCase: A => B, f: (B, B) => B): B =
      f(left.fold(baseCase, f), right.fold(baseCase, f))
  }
  case class Leaf[A](value: A) extends Tree[A] {
    def fold[B](baseCase: A => B, f: (B, B) => B): B =
      baseCase(value)
  }

  val tree: Tree[String] = Node(
    Node(Leaf("To"), Leaf("iterate")),
    Node(
      Node(Leaf("is"), Leaf("human,")),
      Node(Leaf("to"), Node(Leaf("recurse"), Leaf("divine")))
    )
  )

  println(tree.fold[String](stringValue => stringValue, (a, b) => a + " " + b))

}
