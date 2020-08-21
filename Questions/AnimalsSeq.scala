object Runner extends App {
  val animals = Seq("cat", "dog", "penguin")
  println(animals)
  //append and prepend items
  println(("mouse") +: animals :+ ("dinosaur"))
  //prepend Int ?
  // Will return a Seq of type Any ..
  println((1) +: (animals))

}
