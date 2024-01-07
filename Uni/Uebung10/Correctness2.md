mult(x, y) { y == 0 ? 0 : x + mult(x, y - 1) }

1. Induktionsanfang: Überprüfung der Aussage für den Anfangswert (y = 0 → Abbruchbedingung)
    mult(x, 0) = 0 ✔

2. Induktionsvoraussetzung: Annahme, dass Aussage für y = z wahr (0 ≤ z ≤ y)
    mult(x, z) = x · z für alle 0 ≤ z ≤ y

3. Induktionsschritt: Beweis, dass Aussage für z = y + 1 wahr
    mult(x, y + 1) = x + mult(x, y), da y + 1 ≥ 0
    x + mult(x, y) = x + x * y (aus Voraussetzung)
    x + x * y = x * (y + 1) ✔