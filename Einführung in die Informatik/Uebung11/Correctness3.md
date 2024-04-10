Korrektheit 2
---

** Aufgabe 1 - Korrektheit imperativ definierter Algorithmen **

1.
int W; // temporary
int Z; // Output
int X, Y; // Input

Z = 1; W = Y; // for [Y >= 0]

while (W != 0) { Z *= X; W--; } // for [X^Y = Z * X^W]

// successful for [Z = X^Y]

Beweis der partiellen Korrektheit:

Spezifikation: (Vor) = {[Y >= 0]} POW {[Z = X*Y]} = (Nach)
Schleifeninvariante: (P) = {[X^Y = Z * X^W]}, (P') = {[X^Y = Z' * X^W']}

Schritt 1: Gilt Invariante bei Eintritt in Schleife?
(Vor) Z' = 1; W' = Y (P'), denn [X^Y = Z' * X^W'] = 1 * X^Y = X^Y
→ Invariante gilt bei Eintritt in Schleife (while (W != 0) { Z *= X; W--; })

Schritt 2: Gilt Invariante während Iteration?
{[(P) ∧ W != 0]} Z *= X; W-- [(P)] → {[(P) ∧ W != 0]} Z *= X; W-- {[(P') ∧ W != 0]} → [(P)] ↔ [(P')]?
[X' = X, Y' = Y, Z' = Z * X, W' = W - 1] → (P') ↔ X^Y = [Z * X * X^(W - 1)] = [Z * X * X^W * 1/X] = Z * X^W ↔ (P)
→ Invariante gilt während Iteration (while (W != 0) { Z *= X; W--; })

Schritt 3: Zum Verlassen der Schleife muss gelten [(P) ∧ W = 0], gilt dann auch (Nach)?
[(P) ∧ W = 0] → X^Y = [Z * X^W ∧ W = 0] → [X^Y = Z * X^0] = Z * 1 = Z ✔
→ (Nach) liefert Ergebnis von POW

→ Der Algorithmus ist partiell korrekt.

2.
Um die totale Korrektheit bezüglich Vor- und Nachbedingung zu zeigen, fehlt der Beweis, dass der Algorithmus terminiert.

---

** Aufgabe 2 - Korrektheit rekursiv definierter Algorithmen **

1.
mult(x, y) = x * y;
pred(x) = x - 1;
pow(x, y) { y == 0 ? 1 : mult(pow(x, pred(y)), x)

1.1. Induktionsanfang: Überprüfung der Aussage für den Anfangswert (y = 0 → Abbruchbedingung)
    pow(x, 0) = 1 ✔

1.2. Induktionsvoraussetzung: Annahme, dass Aussage für y = z wahr (0 ≤ z ≤ y)
    pow(x, z) = x^z für alle 0 ≤ z ≤ y

1.3. Induktionsschritt: Beweis, dass Aussage für z = y + 1 wahr
    pow(x, y + 1) = mult(pow(x, pred(y + 1)), x), da y + 1 ≥ 0
    mult(pow(x, pred(y + 1)), x) = mult(pow(x, y), x), da pred(y + 1) = y
    mult(pow(x, y), x) = mult(x^y, x) (aus Voraussetzung)
    mult(x^y, x) = x^y * x, da mult(x, y) = x * y
    x^y * x = x^(y + 1) ✔

→ für y >= 0 gilt pow(x, y) = x^y

2.
Eine partielle Funktion zeichnet sich dadurch aus, dass Der Definitions- und oder der Wertebereich von x und oder y
eingeschränkt ist/sind. Im obigen Beispiel ist es daran erkennbar, dass die Funktion nur für y ≥ 0 definiert ist.