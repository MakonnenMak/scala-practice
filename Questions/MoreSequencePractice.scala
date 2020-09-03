object Runner extends App {
  // Write method to find smallest element in a Seq[Int]
  def findMin(seq: Seq[Int]): Int =
    seq.sortWith((a, b) => a < b).head
  // Given Seq[Int] create a Seq[Int] containing only the unique elements

}
