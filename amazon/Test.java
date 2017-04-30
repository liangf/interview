
import java.util.*;

// final class Node implements Comparable<Node> {

//   private final int x;
//   private final int y;

//   Node(int x, int y) {
//     this.x = x;
//     this.y = y;
//   }

//   @Override public boolean equals(Object other) {
//     if (!(other instanceof Node)) {
//       return false;
//     }
//     Node otherNode = (Node) other;
//     return x == otherNode.x && y == otherNode.y;
//   }

//   @Override public int hashCode() {
//     return x * 31 + y * 17; // For example...
//   }

//   @Override public int compareTo(Node other) {
//     // As of Java 7, this can be replaced with
//     // return x != other.x ? Integer.compare(x, other.x) 
//     //     : Integer.compare(y, other.y);

//     if (x < other.x || (x == other.x && y < other.y)) {
//       return -1;
//     }
//     return x == other.x && y == other.y ? 0 : 1;
//   }
// }


class MyComp implements Comparator<Node> {
    public int compare(Node n1, Node n2) {
     return n1.x < n2.x ? 1 : -1;
    }
     
}

final class Node {

  final int x;
  final int y;

  Node(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override public boolean equals(Object other) {
    if (!(other instanceof Node)) {
      return false;
    }
    Node otherNode = (Node) other;
    return x == otherNode.x && y == otherNode.y;
  }

  @Override public int hashCode() {
    return x * 31 + y * 17; // For example...
  }

  // @Override public int compareTo(Node other) {
  //   // As of Java 7, this can be replaced with
  //   // return x != other.x ? Integer.compare(x, other.x) 
  //   //     : Integer.compare(y, other.y);

  //   if (x < other.x || (x == other.x && y < other.y)) {
  //     return -1;
  //   }
  //   return x == other.x && y == other.y ? 0 : 1;
  // }
}

public class Test {

    public static void main(String[] args) {
      System.out.println("hahhahha");

      // TreeSet<Node> set = new TreeSet<Node>();
      TreeSet<Node> set = new TreeSet<Node>(new MyComp());

      Node n1 = new Node(1, 2);
      Node n2 = new Node(2, 3);

      List<Node> list = new ArrayList<Node>();
      list.add(n1);
      list.add(n2);

      set.add(n1);
      // for (int i=0; i<list.size(); ++i) {

      // }

      System.out.println(set.contains(n1));
    }
}