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
        case SquareRoot(n) =>
          n.eval match {
            case Failure(reason) => Failure(reason)
            case Success(n) =>
              if (n < 0)
                Failure("Can't square root a negative")
              else
                Success(math.sqrt(n));
          }
      }
  }
  // Data type for various operations
  final case class Addition(left: Expression, right: Expression)
      extends Expression;
  final case class Division(numerator: Expression, denominator: Expression)
      extends Expression;
  final case class SquareRoot(value: Expression) extends Expression;
  final case class Number(value: Double) extends Expression;

  // Tests
  val ten = Number(10);
  val five = Number(5);
  val zero = Number(0);
  val negativeNum = Number(-5)
  val myAdd = Addition(ten, five);
  val myDivideSuccess = Division(ten, five);
  val myDivideFailure = Division(ten, zero);
  val mySquareRootSuccess = SquareRoot(ten);
  val mySquareRootFailure = SquareRoot(negativeNum);

  // Output
  println("10+5 ", myAdd.eval)
  println("10/5 ", myDivideSuccess.eval)
  println("10/0 ", myDivideFailure.eval)
  println("Sqrt(10) ", mySquareRootSuccess.eval)
  println("Sqrt(-5) ", mySquareRootFailure.eval)

}
