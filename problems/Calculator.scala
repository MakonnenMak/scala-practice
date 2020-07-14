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
        case Division(n, d) =>
          n.eval match {
            case Failure(message) => Failure(message)
            case Success(numeratorResult) =>
              d.eval match {
                case Failure(reason) => Failure(reason)
                case Success(denominatorResult) =>
                  if (denominatorResult == 0)
                    Failure("Can't divide by 0")
                  else
                    Success(numeratorResult / denominatorResult)
              }
          }
      }
  }

  final case class Addition(left: Expression, right: Expression)
      extends Expression;
  final case class Division(numerator: Expression, denominator: Expression)
      extends Expression;
  final case class Number(value: Double) extends Expression;
  val ten = Number(10);
  val five = Number(5);
  val zero = Number(0);
  val myAdd = Addition(ten, five);
  val myDivideSuccess = Division(ten, five);
  val myDivideFailure = Division(ten, zero);
  println(myAdd.eval)
  println(myDivideSuccess.eval)
  println(myDivideFailure.eval)

}
