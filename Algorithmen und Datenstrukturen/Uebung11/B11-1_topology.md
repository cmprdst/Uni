Topologisches Sortieren
---


    ╭------------→ 15                                                                          15. Cola kaufen
    5 ----→ 4       |  5. In die Stadt fahren      4. Mathebuch aus Bibliothek holen
    ↓     ↙   ↘     |
    7 → 16 ---→ 1   |  7. Freund(in) vom Bahnhof abholen   16. aus der Stadt zurückkommen  1. Mathehausaufgaben machen
    |  / ↓ \↖╮  ↑   |                                                       
    | / 10  \╰--┼- 13              10. Computer aufbauen                                       13. Spülmittel kaufen
    ↓↙   ↓   \  |   ↓                                              
    9 ← 12   ╰--┼-→ 2  9. Internet-Recherche nach Musik    12. Computer am Netz anschließen    2. Abwaschen
    ↓    ↓      |   ↓
    3    6      |   8  3. Partymusik bei Spotify/iTunes zusammenstellen    6. AuD-Übung vorbereiten    8. Schuhe putzen
         ↓      |   ↓                                              
        14 -----╯  11              14. AuD Aufgaben bearbeiten                                 11. Müll rausbringen


                5    ┬─┬─╮                  nach Tarjan 1976:
                15  ←╯ │ │ ╮                1. rufe für jede Senke (Knoten ohne ausgehende Kanten) Algorithmus auf
            ╭   7   ←──╯ │ │ ╮              2. markiere die Senke
          ╭ │   4   ←────╯ │ │ ╮            3. gehe entlang der eingehenden Kanten, markiere die Zielknoten
        ╭ │ │   13  ←──────╯ │ │ ╮          4. Zielknoten hat keine weiteren eingehenden Knoten mehr oder die
        ├ ├ │   16  ←────────┴─┴─╯ ╮           entsprechenden Knoten wurden bereits ausgegeben? Zielknoten ausgeben
        │ │ │   10  ←──────────────┤ ╮      → bottom-up Rekursion → Ausgabe der Knoten von der Quelle bis zur Senke
      ╭ │ │ ├   12  ←━━━━━━━━━━━━━━┿━╯      
      │ │ │ ╰→  9   ←──────────────╯ ╮      alternativ nach Kahn 1962:
      │ │ │     3   ←────────────────╯      1. speichere alle Knoten ohne eingehende Kanten (Quellen) in einem Feld ab
      │ │ │                                 2. gib die Quellen aus
      ╰━┿━┿━━→  6    ╮                      3. entferne die Quellen aus dem Graphen
        │ │     14  ←╯ ╮                    4. füge alle daraus neu entstandenen Quellen dem Feld hinzu
        │ ╰──→  1   ←──╯                    5. Wiederhole Schritt 2 bis 4, bis der Graph leer ist
        │                                   → top-down Iteration → Zyklen, falls Graph nicht leer und keine Quellen mehr
        ╰────→  2    ╮                      
                8   ←╯ ╮                    B) 3: beide eingehenden Kanten zu Scissors, Kante von Rock zu Lizard
                11  ←──╯                    → Scissors, Lizard, Paper, Spock, Rock (mit Algorithmus nach Kahn)