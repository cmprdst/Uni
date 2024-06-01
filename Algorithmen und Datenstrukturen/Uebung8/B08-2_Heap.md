Heap
---

**TODO:** Insert your answer for task 1 - 3!

1.
Unter einem MinHeap versteht man einen Binärbaum, für den für jeden Knoten außer der Wurzel gilt: X >= parent(X).
Das bedeutet, dass der Wert des Elternknotens stets kleiner oder gleich dem Wert des Kinderknotens ist, wobei die
Reihenfolge der Kinder jedoch nicht näher bestimmt ist. Demzufolge kann der kleinste Wert mit nur einer Operation
ausgelesen werden, indem man nämlich den Wert der Wurzel abfragt. 
Dazu kommt eine zusätzliche Struktureigenschaft, die die Balance dieses Baumes sicherstellt. Alle Ebenen sind nämlich
vollständig gefüllt; u. U. ist die letzte nur teilweise, aber immer linksbündig gefüllt.

Ein Heap lässt sich durch level-order-Traversierung auf ein Feld abbilden:

    Beispielbaum:               

                  2             -> kleinster Wert = Wurzel
            /           \
          11             4      -> Eltern < Kinder
        /    \         /   \
      25      20      6    87   -> Kinder nicht geordnet
     /  \    /  \    /
    25  25  27  30  27          -> linksbündig gefüllt, Rest voll

    -> Elternknoten = Kindknoten = Nachbarknoten möglich
    
    k   |   1       2   3       4   5   6   7       8   9   10  11  12      -> Elternknoten = |_ k / 2 _|
    a_k |   2       11  4       25  20  6   13      25  25  27  30  27      -> Kindknoten = links: 2k, rechts: 2k + 1

2.

Über die Position des größten Elements in einem MinHeap lässt sich nur sagen, dass es ein Blattknoten sein muss. Welcher
genau und ob dieser sich in der letzten oder vorletzten Ebene befindet, ist ohne Weiteres nicht abzuleiten.

Ja, ein in aufsteigend sortierter Reihenfolge vorliegendes Feld ist ein Heap, da die Eltern im Feld stets links von den
Kindern stehen und da in diesem Feld der linke Wert immer kleiner als der rechte ist, gilt: Elternknoten < Kindknoten.
Es erfüllt sogar die nicht notwendige Eigenschaft, dass das linke Kind stets kleiner ist als das rechte.

3.

ungeordnetes Feld: 5, 1, 19, 25, 17, 21, 5, 19, 20, 9, 15, 14

upHeap:

    k   |   1       2   3       4   5   6   7       8   9   10  11  12

    a_k |   5       1   19      25  17  21  5       19  20  9   15  14
        |   5       1   19      25  17 _14_ 5       19  20  9   15 _21_     1
        |   5       1  _14_     25  17 _19_ 5       19  20  9   15  21      2                  1
        |   5       1   14      25 _15_ 19  5       19  20  9  _17_ 21      3              /       \
        |   5       1   14      25 _9_  19  5       19  20 _15_ 17  21      4             5         5
        |   5       1   14     _20_ 9   19  5       19 _25_ 15  17  21      5          /     \      |   \
        |   5       1   14     _19_ 9   19  5      _20_ 25  15  17  21      6         19      9     19  14
        |   5       1  _5_      19  9   19 _14_     20  25  15  17  21      7        /  \    /  \   |
        |  _1_     _5_  5       19  9   19  14      20  25  15  17  21      8 ->    20  25  15  17  21      -> ✔

vermutete Komplexität: bis zu n - 1 Einträge tauschen (n bis 2, Wurzel selbst nicht möglich), Tausch bis zur Wurzel 
(k halbiert sich bis 1) → O((n - 1) * log₂(n)) = O(nlog(n))

downHeap:

    k   |   1       2   3       4   5   6   7       8   9   10  11  12
                                                                                               1
    a_k |   5       1   19      25  17  21  5       19  20  9   15  14                     /       \
        |  _1_     _5_  19      25  17  21  5       19  20  9   15  14      1             5         5
        |   1       5  _5_      25  17  21 _19_     19  20  9   15  14      2          /     \      |   \
        |   1       5   5      _19_ 17  21  19     _25_ 20  9   15  14      3         19      9     14  19
        |   1       5   5       19 _9_  21  19      25  20 _17_ 15  14      4        /  \    /  \   |
        |   1       5   5       19  9  _14_ 19      25  20  17  15 _21_     5 ->    25  20  17  15  21      -> ✔

vermutete Komplexität: bis zu n/2 Einträge tauschen (Rest hat keine Kinder mehr), Tausch, solange 2k < n
→ O(n/2 * log₂(n)) = O(nlog(n))