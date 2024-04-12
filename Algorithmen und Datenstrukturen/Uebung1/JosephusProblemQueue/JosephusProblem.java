package Uebung1.JosephusProblemQueue;

public class JosephusProblem {

  public static Queue<String> solve(String[] persons, int k) {
    if (persons.length == 0) {
      System.err.println("The Josephus Problem need not be solved if no people are involved.");
      return null;
    }
    if (k <= 0) {
      System.err.println("The Josephus problem makes no sense for a syllable count lower than 1.");
      return null;
    }

    Queue<String> initialPersonOrder = new Queue<>(persons.length);
    for (String person : persons) initialPersonOrder.enqueue(person);
    if (k == 1 || persons.length == 1) return initialPersonOrder;

    Queue<String> CountedOutPersonOrder = new Queue<>(persons.length);
    int counter = 0;

    while (!initialPersonOrder.is_empty()) {
      int oldQueueLength = persons.length - counter;
      // spezielle Bedingung für i verhindert, dass für eine geringe Restanzahl von Pers. < k unnötig oft "gezählt" wird
      for (int i = 1; i < (k % oldQueueLength == 0 ? oldQueueLength : k % oldQueueLength); i++) {
        initialPersonOrder.enqueue(initialPersonOrder.dequeue());
      }
      counter++;
      CountedOutPersonOrder.enqueue(initialPersonOrder.dequeue());
    }

    return CountedOutPersonOrder;
  }

  public static void main(String[] args) {
    String[] empty = {};
    String[] JosephusAndFriends = {"eins", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun", "zehn",
            "elf", "zwölf", "dreizehn"};

    System.out.println(solve(JosephusAndFriends, 7));
    System.out.println(solve(empty, 5));
    System.out.println(solve(JosephusAndFriends, 0));
  }
}