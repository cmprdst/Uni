Solution
---
1.
AVL-Bäume (benannt nach **A**delson-**V**elskii und **L**andis) gehören zu den Binärbäumen, was bedeutet, dass jeder
Elternknoten maximal einen linken und rechten Kindknoten hat. Sie zeichnen sich durch das AVL-Kriterium aus, welches
besagt, dass sich an allen Knoten (global für alle Teilbäume) die Höhen der linken und rechten Teilbäume um höchstens 1
unterscheiden. Dadurch ergibt sich die Balance des Baumes als Höhendifferenz bal(T) := h(T_R) - h(T_L) ∈ {-1, 0, 1}.

Der Ausgleich binärer Bäume dient der Effizienzsteigerung. Im schlimmsten Fall könnte ein Baum zu einer Liste mit Höhe n
degenerieren, wobei n die Anzahl der Knoten im Baum bezeichnet. Das würde dazu führen, dass Operationen wie das Suchen,
Einfügen und Entfernen von Knoten einen linearen Aufwand aufweisen würden (O(n)). Das Ausbalancieren begrenzt die Höhe
auf ~log(n), was den nötigen Aufwand für die genannten Operationen signifikant verringert (O(log(n))).

2.
Show what happens during the insertion of the numbers 14, 15, 17, 7, 5, 10 and 16 (in this order) into an AVL-Tree!

Fall 1: Links-Rechts (LR) |-(Rotation links (Rl))-> Links-Links (LL) |-(Rotation rechts (Rr))-> Ausgleich
Fall 2: Rechts-Links (RL) |-(Rotation rechts (Rr))-> Rechts-Rechts (RR) |-(Rotation links (Rl))-> Ausgleich

    14 ->  14      ->  14 (RR)     ->      15      ->          15      ->              15      ->          15      ->
              \           \        Rl    /    \              /    \                  /    \    Rr        /    \
               15          15          14      17          14      17         (LL) 14      17          7       17
                              \                          /                       /                   /   \
                               17                      7                       7                   5       14
                                                                             /
                                                                           5

            15 (LR) ->             15 (LL) ->         14         ->         14          ->  .       ->        14
          /    \    Rl           /    \    Rr       /    \                /    \        Rr  .       Rl      /    \
        7       17             14      17         7       15            7       15 (RL)     .             7       16
      /   \                  /                  /   \        \        /   \        \        . (RR)       / \     /  \
    5       14             7                  5       10      17    5       10      17      16          5   10  15  17
          /              /   \                                                    /            \  
         10            5      10                                                16              17