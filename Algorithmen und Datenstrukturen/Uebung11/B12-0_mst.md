MST: Algorithmus von Prim
---

    1.      0           1.      pr(0) = 0       p[0] = -1   PQ: 0
          ╱ │ ╲         2.  0:  pr(2) = 5       p[2] = 0    PQ: 2
      ⁵ ╱  ³│   ╲ ²             pr(3) = 3       p[3] = 0    PQ: 3, 2
      ╱  ₁  │     ╲             pr(1) = 2       p[1] = 0    PQ: 1, 3, 2 → 0 abgeschlossen (kürzeste Kante 0)
    2 ───── 3      1    3.  1:  pr(5) = 4       p[5] = 1    PQ: 3, 5, 2 → 1 abgeschlossen (kürzeste Kante 2)
    │ ╲     │     ╱     4.  3:  pr(2) = 1 < 5 → p[2] = 3    PQ: 2, 5
    │⁷  ╲⁸  │⁶  ╱⁴              pr(5) = 6 > 4               PQ: 2, 5    → 3 abgeschlossen (kürzeste Kante 3)     
    │  ₉  ╲ │ ╱         5.  2:  pr(4) = 7       p[4] = 2    PQ: 5, 4
    4 ───── 5                   pr(5) = 8 > 4               PQ: 5, 4    → 2 abgeschlossen (kürzeste Kante 1)
                        6.  5:  pr(4) = 9 > 7               PQ: 4       → 5 abgeschlossen (kürzeste Kante 4)
                        7.  4:  ----                        PQ: ----    → 4 abgeschlossen (kürzeste Kante 7)
                                                                        → ∑ Kantengewichte = 0 + 2 + 3 + 1 + 4 + 7 = 17