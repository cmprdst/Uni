Red-Black-Tree
---
Insert your answers and solutions for the Red-Black-Tree tasks!

***Teil A***

Unter einem Rot-Schwarz-Baum versteht man einen binären Suchbaum, dessen Knoten dadurch charakterisiert sind, rot oder 
schwarz zu sein. Die Wurzel, alle Blätter (Null-Knoten) und beide Kinder eines roten Knotens sind schwarz. Außerdem
enthält jeder Pfad von einem Knoten zu einem erreichbaren Blatt dieselbe Anzahl schwarzer Knoten. Dadurch, dass der
Elternknoten und die Kinder eines roten Knotens schwarz sein müssen, entsteht ein alternatives Kriterium für Balance.
Ist diese Eigenschaft verletzt, muss eine Umstrukturierung erfolgen; die Wurzel kann umgefärbt werden.

für n Knoten gilt: \
    benötigter Speicherplatz in O(n), Suchen, Einfügen und Löschen in O(log(n)), da Höhe durch Balance-Krit. ∈ O(log(n))

***Teil B***

Zahlenreihe = {6, 7, 3, 4, 2, 1} \
+?+ = schwarz, -?- = rot \
rO = roter Onkel -> Umfärben, sO = schwarzer Onkel -> Umstrukturierung

    -6- -> +6+ -> +6+   ->   +6+   ->   +6+     ->   +6+   ->     +6+   ->       +6+   ->       +6+
                    \        / \        / \          / \          / \            / \            / \
                    -7-    -3- -7-    -3- -7-      +3+ +7+      +3+ +7+        +3+ +7+        -3- +7+
                                        \            \          / \            / \            / \
                                        -4-(rO)      -4-      -2- -4-        -2- -4-        +2+ +4+
                                                                             /              /
                                                                           -1-(rO)        -1-

Es entstehen Rot-Rot-Verstöße, wann immer ein neuer Knoten eingefügt wird, dessen Elternknoten ebenfalls rot ist. Auch
das Umfärben und Umstrukturieren kann dazu führen, dass rote Knoten in direkter Verwandtschaft zueinander stehen.
Dadurch entsteht ein nicht ausbalancierter Baum, da das Balance-Kriterium nicht mehr erfüllt ist.

***Teil C***

(LL) = Links-Links, Rr = Rotation rechts

    6 -> 6   ->   6   ->   6   ->     6   ->       6(LL) ->     3
          \      / \      / \        / \          / \    Rr    / \
           7    3   7    3   7      3   7        3   7        2   6
                          \        / \          / \          /   / \
                           4      2   4        2   4        1   4   7
                                              /
                                             1

Der AVL-Baum und der Schwarz-Rot-Baum sind bis auf den letzten Schritt und die fehlende Färbung beim AVL-Baum identisch.
Da beim AVL-Baum keine Farben Verwendung finden, wird umstrukturiert. Im speziellen Fall für den Schwarz-Rot-Baum war
eine Umfärbung ausreichend.

***Teil D***

    2-3-4-Baum:             Rot-Schwarz-Baum:

        2-Knoten: a                             +a+

                                                +b+
        3-Knoten: a|b                           /           -> Jeder 2-3-4-Baum kann als R-S-Baum dargestellt werden.
                                              -a-
    
                                                +b+
        4-Knoten: a|b|c                         / \
                                              -a- -c-