object Runner extends App {
  // Write method to find smallest element in a Seq[Int]
  def findMin(seq: Seq[Int]): Int =
    seq.sortWith((a, b) => a < b).head
  // Given Seq[Int] create a Seq[Int] containing only the unique elements

  def addUnique(seq: Seq[Int], value: Int): Seq[Int] =
    if (seq contains value)
      seq
    else
      seq :+ (value)
  def findUnique(seq: Seq[Int]): Seq[Int] =
    seq.foldLeft(Seq[Int]())((prevSeq, nextVal) => addUnique(prevSeq, nextVal))

  def reverseHelper(seq: Seq[Int], value: Int): Seq[Int] =
    (value) +: seq

  def reverseWithFold(seq: Seq[Int]): Seq[Int] =
    seq.foldLeft(Seq[Int]())((prevSeq, nextVal) =>
      reverseHelper(prevSeq, nextVal)
    )

}
