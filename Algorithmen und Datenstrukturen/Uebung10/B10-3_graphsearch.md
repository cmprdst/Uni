Breiten- und Tiefensuche am Beispiel
---

    5 ------------- 7   Breitensuche:   Queue:  8 → 1 → 2 → 3 → 5 → 6 → 7 → 4   → - Startknoten enqueuen
    | \╲            |   → Knoten in                 2   3   5   6   7   4         - vom Startknoten aus alle erreich-
    | | └-- 8 - 3 ╮ |   der Nachbar-                3   5   6   7   4               baren Knoten der Größe nach enqueuen
    |  \    |└---┐| |   schaft werden               5   6   7                     - der Reihe nach dequeuen und bei
    |  |    2 --┐\\ |   zuerst abge-                    7                           jedem neuen Knoten noch nicht
    |   \        ╲╲\|   arbeitet                                                    erreichbar gewesene Knoten enqueuen
    4 - 6 --------- 1   → Queue                                                   - Queue leer → Algorithmus terminiert

    rekursive Tiefensuche:  8               → (in diesem Beispiel kleinerer) nächster erreichbarer Knoten die 1
                            → 1             → von der 1 aus nächster Knoten die 2
                              → 2           → von der 2 aus kein nächster Knoten → zurück zur 1, nächster Knoten die 3
                              → 3           → von der 3 aus kein nächster Knoten → zurück zur 1, nächster Knoten die 6
                              → 6           → von der 6 aus nächster Knoten die 4
                                → 4         → von der 4 aus nächster Knoten die 5
                                  → 5       → von der 5 aus nächster Knoten die 7
                                    → 7     → alle Knoten markiert → rekursive Abstiege laufen zurück
                                     <-
                                   <-
                                 <-
                               <-
                             <-
                            end             → Algorithmus terminiert