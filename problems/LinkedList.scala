object runner extends App{

  // Generic Single Linked List Data Type

  sealed trait LinkedList[A]{
    def length:Int = {
      this match{
        case End() => 0;
        case Pair(h,t)=> 1 + t.length
      }
    }

    def contains(someVal:A):Boolean ={
      this match{
        case End() => false;
        case Pair(h,t) => if(someVal==h) return true else t.contains(someVal)
      }
    }

    def apply(index:Int):A ={
      this match{
        case End() => throw new Exception("Attemptedto get element from Empty List");
        case Pair(h,t) => 
      }
    }
  };

  final case class End[A]() extends LinkedList[A];
  final case class Pair[A](head:A,tail:LinkedList[A]) extends LinkedList[A];

  val myIntLL = Pair(1,Pair(2,Pair(3,End())));
  val myStringLL = Pair("Hello",Pair("Testing",Pair("Generics",End())));

}
