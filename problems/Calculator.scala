object runner extends App {
  // Simple interpreter for numerical operations

  //Data type for Success and Failure of Calculation
  sealed trait Calculation;
  final case class Success(result: Double) extends Calculation;
  final case class Failure(message: String) extends Calculation;

  // AST
  sealed trait Expression {
    def eval: Calculation =
      this match {
        case Number(value) => Success(value);
        case Addition(l, r) =>
          l.eval match {
            case Failure(message) => Failure(message)
            case Success(leftResult) =>
              r.eval match {
                case Failure(reason)      => Failure(reason)
                case Success(rightResult) => Success(leftResult + rightResult)
              }
          }
      }
  }

  final case class Addition(left: Expression, right: Expression)
      extends Expression;
  final case class Number(value: Double) extends Expression;
  val num1 = Number(10);
  val num2 = Number(5);
  val myAdd = Addition(num1, num2);
  println(myAdd.eval)
}
