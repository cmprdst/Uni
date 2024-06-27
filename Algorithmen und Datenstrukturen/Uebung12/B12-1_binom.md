Binomialkoeffizient mit Pascalschem Dreieck
---

1.


    input n, k // Zeilen und Spalten
    table := Array (n + 1, k + 1, 0) // gefüllt mit 0en
    foreach i in 0, ..., n do 
        table[i, 0] := 1;
        if i <= k then 
            table[i, i] := 1; 
        fi
    od

    foreach i in 2, ..., n do
        foreach j in 1, ..., min(i - 1, k) do
            table[i, j] = table[i - 1, j - 1] + table[i - 1, j];
        od
    od
    output table[n, k]

    Komplexität: O((n - 2) * ((k - 1) / 2) = O(n * k)

        ║ 0 │ 1 │ 2 │ 3 │ 4 │ 5 
    ════╬═══╪═══╪═══╪═══╪═══╪═══
     0  ║ 1              ←  ╭─╮
     1  ║ 1   1             │ │
     2  ║ 1   2   1         ╰─╯
     3  ║ 1   3   3   1       ↓
     4  ║ 1   4   6   4   1           
     5  ║ 1   5   10  10  5   1
     6  ║ 1   6   15  20  15  6
     7  ║ 1   7   21  35  35  21

3.


    Die Anzahl der Rechenschritte lässt sich weiter reduzieren, da das Pascalsche Dreieck symmetrisch ist, deswegen
    könnte man, anstatt alle Tabelleneinträge zu berechnen, auch nur die Hälfte berechnen und den rest spiegeln,
    bspw. table[3, 1] = table[3, 2], table[4, 1] = table[4, 3] usw. → table[n, k] = table[n, n - k].
    Also würde für n = 7 und k = 5 eine Tabelle mit n + 1 Zeilen und n - k Spalten reichen, da table[7, 5] = table[7, 2]

4.

    
    (7 5) =   (6 5) =   (5 5) =   1     =   1     =   1     =   1     =   1 = 21
                      + (5 4)   + (4 4)   + 1       + 1       + 1       + 1
                                + (4 3)   + (3 3)   + 1       + 1       + 1
                                          + (3 2)   + (2 2)   + 1       + 1
                                                    + (2 1)   + (1 1)   + 1
                                                              + (1 0)   + 1
            + (6 4)   + (5 4)   + (4 4)   + 1       + 1       + 1       + 1
                                + (4 3)   + (3 3)   + 1       + 1       + 1
                                          + (3 2)   + (2 2)   + 1       + 1
                                                    + (2 1)   + (1 1)   + 1
                                                              + (1 0)   + 1
                      + (5 3)   + (4 3)   + (3 3)   + 1       + 1       + 1
                                          + (3 2)   + (2 2)   + 1       + 1
                                                    + (2 1)   + (1 1)   + 1
                                                              + (1 0)   + 1
                                + (4 2)   + (3 2)   + (2 2)   + 1       + 1
                                                    + (2 1)   + (1 1)   + 1
                                                              + (1 0)   + 1
                                          + (3 1)   + (2 1)   + (1 1)   + 1
                                                              + (1 0)   + 1
                                                    + (2 0)   + 1       + 1

    Aufwand: O(2^n) >> O(n * k)