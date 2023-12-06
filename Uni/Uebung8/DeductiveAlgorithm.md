f(0, 1)                             | für X = 0 ergibt Y = 1
X > 0 AND f(X - 1, Y) → f(X, 2 * Y) | ist X > 0 wird X -= 1 und Y *= 2

f(X, 64)?                           | Rückwärtsiteration für X = 0 → Y /= 2 und X += 1 bis Y = 1 (Terminalbedingung)
f(1, 32), f(2, 16),
f(3, 8), f(4, 4),
f(5, 2), f(6, 1)                    | →  X = 6

f(X, 67)?                           | 67 / 2 ergibt keine natürliche Zahl, es gibt kein Ergebnis

f(3, Y)?                            | Algorithmus kann wie beschrieben durchgeführt werden für Y = 1
f(2, 2), f(1, 4), f(0, 8)           | Y = 8

Dieser deduktive Algorithmus beschreibt für natürliche Zahlen X und Y eine Potenz von 2^X mit dem Ergebnis Y.