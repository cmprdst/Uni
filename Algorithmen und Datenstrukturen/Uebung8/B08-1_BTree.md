B-Tree
---

**TODO:** Insert your answer for task 1!

B-Baum mit Seitengröße m = 2 und Höhe = 3:

Mindestanzahl Schlüssel:

    -> "Jeder Knoten hat mindestens m Schlüssel (mit Ausnahme der Wurzel)."
        Wurzel-Minimum: 1 Schlüssel
    -> "Jeder innere Knoten mit k Schlüsseln hat k+1 Kinder."
        Wurzel-Kinder: 1 + 1 = 2
    -> Minimum Wurzel-Kinder: 2 * 2 = 4 Schlüssel
        Wurzel-Enkel: 2 * (2 + 1) = 6
    -> Minimum Wurzel-Enkel: 6 * 2 = 12 Schlüssel

= **17**

Maximalanzahl Schlüssel:
    
    -> "Jeder Knoten hat höchstens 2m Schlüssel"
        Wurzel-Maximum: 2 * 2 = 4 Schlüssel
    -> "Jeder innere Knoten mit k Schlüsseln hat k+1 Kinder."
        Wurzel-Kinder: 4 + 1 = 5
    -> Maximum Wurzel-Kinder: 5 * (2 * 2) = 20 Schlüssel
        Wurzel-Enkel: 5 * (4 + 1) = 25
    -> Maximum Wurzel-Enkel: 25 * (2 * 2) = 100 Schlüssel

= **124**