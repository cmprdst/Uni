Rucksackproblem am Beispiel
---

1.

    
    Greedy-Kriterium: Wert pro Einheit Größe

        a₁ = 3 / 3 = 1      → 4. → Restgröße nicht genug
        a₂ = 5 / 4 = 1,25   → 3. → Restgröße nicht genug
        a₃ = 8 / 6 = 1,3... → 1. → Restgröße Rucksack = 9
        a₄ = 9 / 7 ≈ 1.286  → 2. → Restgröße Rucksack = 2

        → Wert: 9 + 8 = 17 nach Greedy-Methode, zufällig optimal

2.


    Das Prinzip der dynamischen Programmierung dient dem Ermitteln einer optimalen Lösung für eine Problemstellung mit
    einschränkenden Nebenbedingungen. In diesem Beispiel soll der Wert des Inhalts des Rucksacks maximiert werden, wobei
    er nur eine Größe von 15 aufweist, sodass die eingepackten Objekte diese Größe nicht übersteigen dürfen.

    Die dynamische Programmierung baut darauf auf, dass ein Problem in Teilprobleme zerlegt werden kann, deren 
    effiziente Lösung einfacher ist, und dass die optimale Lösung dieser Teilprobleme wiederum auf die optimale Lösung
    des gesamten Problems schließen lässt. Außerdem müssen sich die optimalen Teillösungen überlappen, damit Raum zur
    Optimierung gegeben ist, indem wiederkehrende Teillösungen nicht erneut berechnet sondern gespeichert werden.
    Für das Rucksackproblem bedeutet das, es wird abgewogen, ob das Mitnehmen oder das Liegenlassen eines Objekts einen
    größeren Nutzen stiftet. 
    Man beginnt mit dem ersten Objekt (a₁) und trägt den Wert dafür in die Tabelle mit den Indizes [a, g] ein für alle
    g(a₁): g(a₁) <= g <= G (Gesamtgröße). Anschließend fährt man mit dem zweiten Objekt fort und ermittelt, ob das
    erste, das zweite oder beide zusammen den größtmöglichen Wert besitzen, vorausgesetzt die betrachtete Größe ist
    ausreichend. Der Algorithmus wird fortgeführt, bis die maximale Anzahl an Objekten und Größen berücksichtigt wurde, 
    sodass die gewünschte Lösung in der letzten Spalte der letzten Zeile steht.

        ║ 0 │ 1 │ 2 │ 3 │ 4 │ 5 │ 6 │ 7 │ 8 │ 9 │ 10 │ 11 │ 12 │ 13 │ 14 │ 15   
    ════╬═══╪═══╪═══╪═══╪═══╪═══╪═══╪═══╪═══╪═══╪════╪════╪════╪════╪════╪════  → Fußnote ≙ optimale Objektkombination
      1 ║ 0   0   0   3₁  3   3   3   3   3   3    3    3    3    3    3    3   → Wert des ersten Objekts
      2 ║ 0   0   0   3   5₂  5   5   8₁₂ 8   8    8    8    8    8    8    8   → Werte a₁ / a₂ einzeln ≷ zusammen ?
      3 ║ 0   0   0   3   5   5   8₃  8   8 11₁₃ 13₂₃  13   13  16₁₂₃ 16   16   → *¹ a₂ + a₃ = a₁ + a₄
      4 ║ 0   0   0   3   5   5   8   9₄  9  11  13*¹ 14₂₄  14  17₃₄ 17*² *17*  → *² a₃ + a₄ = a₁ + a₂ + a₄