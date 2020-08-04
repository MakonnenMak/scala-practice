object runner extends App {

  // Integer binary tree algebraic data type with corresponding calculator
  // TODO: Add ability to have an empty Tree
  sealed trait Tree;
  final case class Leaf(element: Int) extends Tree;
  final case class Node(leftChild: Tree, rightChild: Tree) extends Tree;

  object TreeCalculator {
    def sum(tree: Tree): Int =
      tree match {
        case Leaf(element: Int)       => element
        case Node(lc: Tree, rc: Tree) => sum(lc) + sum(rc)
      }
  }

  // Simple test case
  val myTree = Node(Node(Node(Leaf(1), Leaf(4)), Leaf(10)), Leaf(5));
  assert(TreeCalculator.sum(myTree) == 20);
}
