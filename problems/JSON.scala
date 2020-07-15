object runner extends App {
  // Design algebraic data-type for JSON

  // JSON Values Data
  sealed trait JSON;
  final case class JsNumber(value: Double) extends JSON;
  final case class JsString(value: String) extends JSON;
  final case class JsBoolean(value: Boolean) extends JSON;
  final case object JsNull extends JSON;

  // JSON Sequence Data
  sealed trait JsSequence extends JSON;
  final case class SeqCell(head: JSON, tail: JsSequence) extends JsSequence;
  case object SeqEnd extends JsSequence;

  //JSON Object Data
  sealed trait JsObject extends JSON;
  final case class ObjectCell(key: String, value: JSON, tail: JsObject)
      extends JsObject;
  case object ObjectEnd extends JsObject;

}
