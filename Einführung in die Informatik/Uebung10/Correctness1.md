int x, y; // Input
int q, r; // Output

r = x; q = 0; // for [x >= 0, y > 0]

while (r >= y) { r -= y; q++; } // for [r >= 0, y > 0], [q * y + r = x]

// successful for [y > r >= 0], [q * y + r = x]


Beispiel: x = 13, y = 5

r = 13, q = 0 // for [x >= 0, y > 0] ✔ (13 >= 0, 5 > 0)

while (r >= y) { // for [r >= 0, y > 0], [q * y + r = x] ✔ (13/8/3 >= 0, 5 > 0, 0/1/2 * 5 + 13/8/3 = 13)
    r -= y; // 8, 3 -> r < y → break
    q++;    // 1, 2
}
// successful for [y > r >= 0], [q * y + r = x] ✔ (5 > 3 >= 0, 2 * 5 + 3 = 13)


Beweis der partiellen Korrektheit:

Spezifikation: (Vor) = {[x >= 0, y > 0]} XYZ {[y > r >= 0], [q * y + r = x]} = (Nach)
Schleifeninvariante: (P) = {[r >= 0, y > 0], [q * y + r = x]}, (P') = {[r' >= 0, y > 0], [q' * y + r' = x]}

Schritt 1: Gilt Invariante bei Eintritt in Schleife?
(Vor) r' = x; q' = 0 (P'), denn [r' = x >= 0] und [q' * y + r'] = [0 * y + x] = x
→ Invariante gilt bei Eintritt in Schleife (while (r >= y) { r -= y; q++; })

Schritt 2: Gilt Invariante während Iteration?
[(P) ∧ {r >= y}] r -= y; q++ [(P)] → [(P) ∧ {r >= y}] r' = r - y; q' = q + 1 [(P') ∧ {r' >= y}] → [(P)] <-> [(P')]?
[x' = x, y' = y, r' = r - y, q' = q + 1] → (P') <-> x = [q' * y + r'] = [(q + 1) * y + (r - y)] = [q * y + r] = x <-> (P)
→ Invariante gilt während Iteration (while (r >= y) { r -= y; q++; })

Schritt 3: Zum Verlassen der Schleife muss gelten [(P) ∧ r < y], gilt dann auch (Nach)?
[(P) ∧ r < y] → x = [q * y + r] ∧ [y > r >= 0] ✔
→ (Nach) liefert Ergebnis von XYZ

→ Der Algorithmus ist partiell korrekt.