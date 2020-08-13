object Runner extends App {
  // Convert Tree to String
  sealed trait Tree[A] {
    def fold[B](leaf: A => B, convert: (B, B) => B): B;
  }
  case class Node[A](left: Tree[A], right: Tree[A]) extends Tree[A] {
    def fold[B](leaf: A => B, convert: (B, B) => B): B =
      convert(left.fold(leaf, convert), right.fold(leaf, convert))
  }
  case class Leaf[A](value: A) extends Tree[A] {
    def fold[B](leaf: A => B, convert: (B, B) => B): B =
      leaf(value)
  }

  val tree: Tree[String] = Node(
    Node(Leaf("To"), Leaf("iterate")),
    Node(
      Node(Leaf("is"), Leaf("human,")),
      Node(Leaf("to"), Node(Leaf("recurse"), Leaf("divine")))
    )
  )

  println(tree.fold[String](value => value, (a, b) => a + " " + b: String));

}
